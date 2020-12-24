package com.revature.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.util.BatchRetriever;
import com.revature.backend.util.BatchRetrieverImpl;

@SpringBootTest(classes={BatchRetriever.class, BatchRetrieverImpl.class})
@RunWith(SpringRunner.class)
public class BatchRetrieverTesting {
    @Autowired
	BatchRetrieverImpl batchRetriever;

	@Test
	void testRetrieveNewlyStagingAssociates() {
        List<ApiAssociateTemplate> a = batchRetriever.retrieveNewlyStagingAssociates();
        assertTrue("associateList size is greater than 0", a.size() > 0);
	}

	@Test
	void testRetrieveNewlyStagingBatches() {
        List<ApiBatchTemplate> b = batchRetriever.retrieveNewlyStagingBatches();
        assertTrue("batchList size is greater than 0", b.size() > 0);
		
	}

}