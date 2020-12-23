package com.revature.backend.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.service.AssociateService;
import com.revature.backend.service.BatchService;

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

	// If using Jackson's ObjectMapper, have a static reference here
	public static ObjectMapper om = new ObjectMapper();

	public BatchRetrieverImpl() {
		logger.info("In BatchRetriever no-args constructor");
	}

	@Override
	public List<Associate> retrieveNewlyStagingAssociates(String json) {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging associates...");

		List<Associate> associateList = new ArrayList<>();

		// call the Caliper to get the associate list information
		try {
			//TODO: find the proper
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");

		} catch (Exception e) {
			logger.warn("Error getting info from Caliper API", e);
		}


		// ending logging activity
		logger.trace("Gathering associate list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return null;
	}

	@Override
	public List<Batch> retrieveNewlyStagingBatches(String json) {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging batches...");

		// call the Caliper to get the associate list information
		List<Batch> batchList = gson.fromJson(json, Batch.class);  

		// ending logging activity
		logger.trace("Gathering batch list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return batchList;
	}

}
