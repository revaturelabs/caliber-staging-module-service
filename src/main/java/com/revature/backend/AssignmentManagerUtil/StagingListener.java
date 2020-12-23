package com.revature.backend.AssignmentManagerUtil;

import java.time.LocalDateTime;
import java.util.List;

import com.revature.backend.model.Batch;

public interface StagingListener {

	public void startListening();
	public void checkForNewBatches();
	public boolean triggerUpdate();
	
	
}
