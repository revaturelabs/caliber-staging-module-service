package com.revature.backend.testing.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.api.ApiAssociateAssignment;
import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.util.BatchRetriever;
import com.revature.backend.util.BatchRetrieverImpl;
import com.revature.backend.util.StagingListener;
import com.revature.backend.util.StagingListenerImpl;

@SpringBootTest(classes={BatchRetriever.class, BatchRetrieverImpl.class, StagingListener.class})
//@SpringBootTest()
@RunWith(SpringRunner.class)
public class BatchRetrieverTesting {

	@MockBean
	StagingListener mockStagingListener;

    @Autowired
	BatchRetrieverImpl batchRetriever;

	@Test
	void testRetrieveNewlyStagingAssociates() {
		testRetrieveNewlyStagingAssociatesHelp(new int[]{});
		testRetrieveNewlyStagingAssociatesHelp(new int[]{0});
		testRetrieveNewlyStagingAssociatesHelp(new int[]{4});
		testRetrieveNewlyStagingAssociatesHelp(new int[]{4, 5});
		testRetrieveNewlyStagingAssociatesHelp(new int[]{2, 7, 15});
		testRetrieveNewlyStagingAssociatesHelp(new int[]{25, 17, 15, 30, 45, 11, 0});
	}

	void testRetrieveNewlyStagingAssociatesHelp(int[] batchSizes) {
		int numAssociates = 0;
		for (int size : batchSizes) numAssociates += size;

		// this list will be returned by the staging listener - the batchRetriever should
		// properly unpack the ApiAssociateTemplates from it
		List<ApiBatchTemplate> mockBatchList 
			= generateBatchTemplates(batchSizes);
		
		when(mockStagingListener.getLatestBatches()).thenReturn(mockBatchList);

		List<ApiAssociateTemplate> associateTemplateList
			= batchRetriever.retrieveNewlyStagingAssociates();

		// make sure all of the associates are included
		assertEquals(numAssociates, associateTemplateList.size());
	}

	@Test
	void testRetrieveNewlyStagingBatches() {
		StagingListenerImpl stagingListener = new StagingListenerImpl();
		stagingListener.checkForNewBatches();
        List<ApiBatchTemplate> b = batchRetriever.retrieveNewlyStagingBatches();
		
		if(stagingListener.triggerUpdate() == true){
			System.out.println("batchList size is greater than 0");
        	assertTrue("batchList size is greater than 0", b.size() > 0);
		}else{
			System.out.println("batchList size is 0!");
			assertTrue("batchList size is 0", b.size() == 0);
		}
	}

	// ----------
	// SHARED HELPER METHODS
	// ----------

	/**
	 * Generates a list of ApiBatchTemplates, where each batch is the size of the
	 * corresponding int in batchSizes.
	 * 
	 * Currently these templates will not be filled out; they will have 
	 * ApiAssociateAssignments, which will have ApiAssociateTemplates. Batch and
	 * Associate templates will have names.
	 * 
	 * @param batchSizes
	 * @return
	 */
	private List<ApiBatchTemplate> generateBatchTemplates(int[] batchSizes) {
		List<ApiBatchTemplate> batchTemplateList = new ArrayList<>();

		// make each Batch
		for (int i = 0; i < batchSizes.length; i++){
			ApiBatchTemplate batch = new ApiBatchTemplate();
			batch.setName("" + i);
			batchTemplateList.add(batch);
			int batchSize = batchSizes[i];
			ApiAssociateAssignment[] assignments = new ApiAssociateAssignment[batchSize];
			batch.setAssociateAssignments(assignments);
			// make each Assignment
			for (int x = 0; x < batchSize; x++){
				ApiAssociateAssignment assign = new ApiAssociateAssignment();
				assignments[x] = assign;
				// make the Associate
				ApiAssociateTemplate assoc = new ApiAssociateTemplate();
				assign.setAssociate(assoc);
				assoc.setFirstName("" + x);
			} // end Assignment for loop
		} // end Batch for loop

		return batchTemplateList;
	}

}