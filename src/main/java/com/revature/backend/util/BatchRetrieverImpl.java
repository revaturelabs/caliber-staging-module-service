package com.revature.backend.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	// If using Jackson's ObjectMapper, have a static reference here
	public static ObjectMapper om = new ObjectMapper();

	public BatchRetrieverImpl() {
		logger.info("In BatchRetriever no-args constructor");
	}

	@Override
	public List<Associate> retrieveNewlyStagingAssociates() {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging associates...");

		List<Associate> associateList = new ArrayList<>();

		// call the Caliper to get the associate list information
		try {
			//NOTE: find the proper endpoint that gets the associates
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/associate");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int statusCode = connection.getResponseCode();

			if(statusCode != 200){
				throw new RuntimeException("ERROR: Status Code - " + statusCode);
			}else{
				String line = "";
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNext()){
					line += scanner.nextLine();
					//change line into an associate object
					Associate a = om.readValue(line, Associate.class);
					//add associate to list
					associateList.add(a);
				}
				scanner.close();
			}
			
		} catch (Exception e) {
			logger.warn("Error getting info from Caliper API", e);
		}
		// ending logging activity
		logger.trace("Gathering associate list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return associateList;
	}

	@Override
	public List<Batch> retrieveNewlyStagingBatches() {
		// start logging activity
		logger.trace("In BatchRetriever: gathering newly staging batches...");

		List<Batch> batchList = new ArrayList<>();

		// call the Caliper to get the associate list information
		try {
			//NOTE: find the proper endpoint that gets the associates
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int statusCode = connection.getResponseCode();

			if(statusCode != 200){
				throw new RuntimeException("ERROR: Status Code - " + statusCode);
			}else{
				String line = "";
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNext()){
					line += scanner.nextLine();
					//change line into an associate object
					Batch b = om.readValue(line, Batch.class);
					//add associate to list
					batchList.add(b);
				}
				scanner.close();
			}
			
		} catch (Exception e) {
			logger.warn("Error getting info from Caliper API", e);
		}
		// ending logging activity
		logger.trace("Gathering batch list is complete. Leaving BatchRetriever...");

		// send found information back to the controller
		return batchList;
	}

}
