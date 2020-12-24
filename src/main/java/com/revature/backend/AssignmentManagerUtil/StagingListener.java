package com.revature.backend.AssignmentManagerUtil;

public interface StagingListener {

	public void startListening();

	public void checkForNewBatches();

	public boolean triggerUpdate();

}
