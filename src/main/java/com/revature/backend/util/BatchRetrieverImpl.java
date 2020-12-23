package com.revature.backend.util;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;

/**
 * This class will handle retrieving associates and batches from the Caliper
 * API.
 * 
 * Methods: (1) retrieveNewlyStagingAssociates(): returns a list of associates
 * who have recently been promoted to staging and who need to be assigned to a
 * manager
 * 
 * (2) retrieveNewlyStagingBatches(): returns a list of batches who have
 * recently been promoted to staging and who need to be assigned to a manager
 * 
 * @author Azhya Knox
 **/
public class BatchRetrieverImpl implements BatchRetriever {

	public static Logger logger = Logger.getLogger(BatchRetrieverImpl.class);

	@Autowired
	private BatchService batchService;

	@Autowired
	private AssociateService associateService;

	public BatchRetrieverImpl() {
		logger.info("In BatchRetriever no-args constructor");
	}

	@Override
	public List<Associate> retrieveNewlyStagingAssociates() {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging associates...");

		// call the appropriate service to get the associate list information
		List<Associate> associateList = associateService.getAllAssociates();

		// ending logging activity
		logger.trace("Gathering associate list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return associateList;
	}

	@Override
	public List<Batch> retrieveNewlyStagingBatches() {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging batches...");

		// call the appropriate service to get the associate list information
		List<Batch> batchList = batchService.getAllBatches();

		// ending logging activity
		logger.trace("Gathering batch list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return batchList;
	}

}
