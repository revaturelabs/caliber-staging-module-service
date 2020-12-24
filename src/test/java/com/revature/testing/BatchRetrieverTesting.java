package com.revature.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.util.BatchRetrieverImpl;

@SpringBootTest()
public class BatchRetrieverTesting {
    @Autowired
	BatchRetrieverImpl batchRetriever;

	@Test
	void testRetrieveNewlyStagingAssociates() {
        List<Associate> a = batchRetriever.retrieveNewlyStagingAssociates();
        assertTrue("associateList size is greater than 0", a.size() > 0);
	}

	@Test
	void testRetrieveNewlyStagingBatches() {
        List<Batch> b = batchRetriever.retrieveNewlyStagingBatches();
        assertTrue("batchList size is greater than 0", b.size() > 0);
		
	}

}