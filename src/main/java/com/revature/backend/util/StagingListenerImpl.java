package com.revature.backend.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
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
import com.revature.backend.model.Batch;
import com.revature.backend.model.api.ApiBatchTemplate;

@Component(value="StagingListener")
public class StagingListenerImpl  implements StagingListener {
	private LocalDateTime nextDateToWaitFor;
	private List<ApiBatchTemplate> latestBatches = new ArrayList<>();
	public static Logger log = Logger.getLogger(StagingListenerImpl.class);
	private DayOfWeek weeklyUpdateDay = DayOfWeek.SUNDAY;
	@Override
	public void startListening() {
		/* Method MUST run on server startup & repeat after each batch check
		 * Configures timer to check for new batches on a specified day of the week every week. 
		 * If this method does not run, the entire sorting system will fail to operate.
		*/
		nextDateToWaitFor = LocalDateTime.now().with(TemporalAdjusters.next(weeklyUpdateDay));
		Date d = Date.from(nextDateToWaitFor.atZone((ZoneId.systemDefault())).toInstant());
		new Timer().schedule(waitToCheckBatches(), d);
		log.info("Restarting stagingListener timer.");
		
	}

	private TimerTask waitToCheckBatches() {
		// TODO Auto-generated method stub
		//Waits to be executed by the new Timer, then checks for any new batches
		checkForNewBatches();
		return null;
	}

	@Override
	public void checkForNewBatches() {
		// TODO Auto-generated method stub
		//Pulls ALL batches from the last year then filters to see only batches with an ending date between two specified parameters
		log.info("Checking for new batches.....");
		latestBatches = new ArrayList<>();
		int year = LocalDateTime.now().getYear();
		try {
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch?year="+year);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int respCode = connection.getResponseCode();
			if(respCode !=200)
			{
				log.error("Caliber API did not respond with a response code of 200!");
				throw new RuntimeException("HttpResonseCode: "+respCode);
			}
			else {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+= sc.nextLine();
				}
				sc.close();
				
				//Process batch data into a usable object
				ObjectMapper mapper = new ObjectMapper();
				ApiBatchTemplate[] myBatches = mapper.readValue(inline, ApiBatchTemplate[].class);
				//Find the last day that the update should have been run.
				LocalDateTime lastDayChecked = LocalDateTime.now().with(TemporalAdjusters.previous(weeklyUpdateDay));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				for( ApiBatchTemplate batch : myBatches)
				{
					LocalDateTime batchDate = LocalDateTime.parse(batch.getEndDate(),formatter);
					
					if(batchDate.isAfter(lastDayChecked) && batchDate.isBefore(LocalDateTime.now()))
					{
						//Batch should be retrieved/id stored for retrieval from another class
						latestBatches.add(batch);
						log.info("New batch found, adding to latestBatches list....");
					}
				}
				if(latestBatches.size() ==0)
				{
					log.info("No new batches found.");
				}
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Failed to retrieve info from Caliber API",e);
		}
		finally {
			//After all code has been executed restart the timer.
			startListening();
		}
	}

	@Override
	public boolean triggerUpdate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<ApiBatchTemplate> getLatestBatches()
	{
		return latestBatches;
	}
	

}
