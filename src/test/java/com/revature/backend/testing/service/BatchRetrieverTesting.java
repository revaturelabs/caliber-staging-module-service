package com.revature.backend.testing.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.util.BatchRetriever;
import com.revature.backend.util.BatchRetrieverImpl;
import com.revature.backend.util.StagingListenerImpl;

@SpringBootTest(classes={BatchRetriever.class, BatchRetrieverImpl.class})
@RunWith(SpringRunner.class)
public class BatchRetrieverTesting {
    @Autowired
	BatchRetrieverImpl batchRetriever;

	@Test
	void testRetrieveNewlyStagingAssociates() {
		StagingListenerImpl stagingListener = new StagingListenerImpl();
		stagingListener.checkForNewBatches();
		List<ApiAssociateTemplate> a = batchRetriever.retrieveNewlyStagingAssociates();
		if(stagingListener.triggerUpdate() == true){
			System.out.println("associateList size is greater than 0");
        	assertTrue("associateList size is greater than 0", a.size() > 0);
		}else{
			System.out.println("associateList size is 0!");
			assertTrue("associateList size is 0", a.size() == 0);
		}
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