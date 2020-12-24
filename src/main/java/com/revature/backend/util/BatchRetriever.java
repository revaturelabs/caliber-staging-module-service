package com.revature.backend.util;

import java.util.List;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;

public interface BatchRetriever {

	public List<Associate> retrieveNewlyStagingAssociates();
	
	public List<Batch> retrieveNewlyStagingBatches();
}
