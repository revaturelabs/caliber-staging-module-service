package com.revature.backend.util;

import java.util.List;

import com.revature.backend.model.api.ApiBatchTemplate;


public interface StagingListener {

	void startListening();
	void checkForNewBatches();
	boolean triggerUpdate();
	List<ApiBatchTemplate> getLatestBatches();
	void setShouldUpdate(boolean shouldUpdate);
	void mockCheckForNewBatches(boolean insertValue);
}
