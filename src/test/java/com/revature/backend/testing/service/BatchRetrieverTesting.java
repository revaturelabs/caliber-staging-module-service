package com.revature.backend.testing.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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
		//StagingListenerImpl stagingListener = new StagingListenerImpl();
		//stagingListener.checkForNewBatches();

		// this list will be returned by the staging listener - the batchRetriever should
		// properly unpack the ApiAssociateTemplates from it
		List<ApiBatchTemplate> mockBatchList = new ArrayList<>();
		// TODO fill out some batch and associate templates
		
		when(mockStagingListener.getLatestBatches()).thenReturn(mockBatchList);

		List<ApiAssociateTemplate> associateTemplateList
			= batchRetriever.retrieveNewlyStagingAssociates();

		
		/*
		if(stagingListener.triggerUpdate() == true){
			System.out.println("associateList size is greater than 0");
        	assertTrue("associateList size is greater than 0", a.size() > 0);
		}else{
			System.out.println("associateList size is 0!");
			assertTrue("associateList size is 0", a.size() == 0);
		}
		*/
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

}