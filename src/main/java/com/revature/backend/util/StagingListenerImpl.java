package com.revature.backend.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.model.api.ApiBatchTemplate;

@Component(value = "StagingListener")
public class StagingListenerImpl implements StagingListener {
	private LocalDateTime nextDateToWaitFor;
	private List<ApiBatchTemplate> latestBatches = new ArrayList<>();
	public static Logger log = Logger.getLogger(StagingListenerImpl.class);
	//Day that the update will occur each week. 
	private DayOfWeek weeklyUpdateDay = DayOfWeek.SUNDAY;
	private boolean shouldUpdate;

	@Override
	public void startListening() {
		/*
		 * Method MUST run on server startup & repeat after each batch check Configures
		 * timer to check for new batches on a specified day of the week every week. If
		 * this method does not run, the entire sorting system will fail to operate.
		 */
		log.info("Restarting stagingListener timer.");
		nextDateToWaitFor = LocalDateTime.now().with(TemporalAdjusters.next(weeklyUpdateDay));
		Date d = Date.from(nextDateToWaitFor.atZone((ZoneId.systemDefault())).toInstant());
		log.info(d);
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				checkForNewBatches();
				// t.cancel();
			}
		}, d);

	}

	@Override
	public void checkForNewBatches() {
		// Pulls ALL batches from the last year then filters to see only batches with an
		// ending date between two specified parameters
		log.info("Checking for new batches.....");
		latestBatches = new ArrayList<>();
		int year = LocalDateTime.now().getYear();
		try {
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch?year=" + year);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int respCode = connection.getResponseCode();
			if (respCode != 200) {
				log.error("Caliber API did not respond with a response code of 200!");
				throw new RuntimeException("HttpResonseCode: " + respCode);
			} else {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();

				// Process batch data into a usable object
				ObjectMapper mapper = new ObjectMapper();
				ApiBatchTemplate[] myBatches = mapper.readValue(inline, ApiBatchTemplate[].class);
				// Find the last day that the update should have been run.
				LocalDateTime lastDayChecked = LocalDateTime.now().with(TemporalAdjusters.previous(weeklyUpdateDay));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				for (ApiBatchTemplate batch : myBatches) {
					//Find the end date of the batch.
					LocalDate ld = LocalDate.parse(batch.getEndDate(), formatter);
					LocalDateTime batchDate = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
					
					//If the end date is between the last date the method was run and the current time, it's a new batch.
					if (batchDate.isAfter(lastDayChecked) && batchDate.isBefore(LocalDateTime.now()) || batchDate.isEqual(LocalDateTime.now())) {
						// Batch should be retrieved/id stored for retrieval from another class
						latestBatches.add(batch);
						log.info("New batch found, adding to latestBatches list....");
					}
				}
				if (latestBatches.size() == 0) {
					log.info("No new batches found.");
					shouldUpdate = false;
				} else {
					shouldUpdate = true;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Failed to retrieve info from Caliber API", e);
		} finally {
			// After all code has been executed restart the timer.
			startListening();
		}
	}

	@Override
	public boolean triggerUpdate() {
		// TODO Auto-generated method stub
		return shouldUpdate;
	}

	@Override
	public List<ApiBatchTemplate> getLatestBatches() {
		return latestBatches;
	}

	// Use this method to set shouldUpdate back to false after updating the
	// database.
	@Override
	public void setShouldUpdate(boolean shouldUpdate) {
		this.shouldUpdate = shouldUpdate;
	}

}
