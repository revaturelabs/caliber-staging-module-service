package com.revature.backend.util;

import java.util.List;

import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;

public interface BatchRetriever {

	List<ApiAssociateTemplate> retrieveNewlyStagingAssociates();
	
	List<ApiBatchTemplate> retrieveNewlyStagingBatches();
}
