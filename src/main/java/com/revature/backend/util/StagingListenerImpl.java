package com.revature.backend.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
	private List<Batch> latestBatches = new ArrayList<>();
	public static Logger log = Logger.getLogger(StagingListenerImpl.class);
	
	@Override
	public void startListening() {
		//Method should run on server startup & repeat after each batch check
		//Will start a seperate thread that keeps track of time. On a specified date
		
		nextDateToWaitFor = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		Date d = Date.from(nextDateToWaitFor.atZone((ZoneId.systemDefault())).toInstant());
		new Timer().schedule(waitToCheckBatches(), d);
		
	}

	private TimerTask waitToCheckBatches() {
		// TODO Auto-generated method stub
		//Waits to be executed by the new Timer, then checks for any new batches and restarts the timer.
		checkForNewBatches();
		return null;
	}

	@Override
	public void checkForNewBatches() {
		// TODO Auto-generated method stub
		//Pulls ALL batches from the last year then filters to see only batches with an ending date between two specified parameters
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
				log.error("Error retrieving data");
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
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			startListening();
		}
	}

	@Override
	public boolean triggerUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
