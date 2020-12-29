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
import com.revature.backend.model.api.ApiAssociateAssignment;
import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;
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


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.model.api.ApiBatchTemplate;
public class GetBatchById {
	
	public GetBatchById() {
		
	}
	
	public ApiBatchTemplate getBatch(int id){
		ApiBatchTemplate batch = new ApiBatchTemplate();
		//System.out.println("in getBatch "+ id);
		try {
			//https://caliber2-mock.revaturelabs.com/mock/training/batch/394
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch/" + id);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int respCode = connection.getResponseCode();
			if (respCode != 200) {
				System.out.println("respCode "+ respCode);
				//throw new RuntimeException("HttpResonseCode: " + respCode);
			}else {
				//System.out.println("connected");
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
//				System.out.println(inline);
				ObjectMapper mapper = new ObjectMapper();
				batch = mapper.readValue(inline, ApiBatchTemplate.class);
				
			}
			
		}catch(Exception E) {
			System.out.println("GetBatchById failed");
		}
		
		return batch;
	}

}
