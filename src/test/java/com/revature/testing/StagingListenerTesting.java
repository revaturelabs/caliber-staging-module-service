package com.revature.testing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.util.StagingListener;
import com.revature.backend.util.StagingListenerImpl;

@SpringBootTest(classes={StagingListener.class, StagingListenerImpl.class})
@RunWith(SpringRunner.class)
public class StagingListenerTesting {

	@Autowired
	StagingListenerImpl stagingListener;
	
	@Test
	void testGetNewBatches()
	{
		stagingListener.checkForNewBatches();
		List<ApiBatchTemplate> batches = stagingListener.getLatestBatches();
		for (ApiBatchTemplate apiBatchTemplate : batches) {
			System.out.println(apiBatchTemplate.toString());
		}
		assertTrue(batches.size() >0);
	}
	
	
}
