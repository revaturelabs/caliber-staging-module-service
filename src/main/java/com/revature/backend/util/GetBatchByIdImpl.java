package com.revature.backend.util;

import java.net.HttpURLConnection;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.model.api.ApiBatchTemplate;

/**
 * This class will handle retrieving a batch by id from the Caliper
 * API.
 * 
 * getBatch(): returns a batch object associated with the id parameter
 * 
 * @author Suva Shahria
 **/
@Component
public class GetBatchByIdImpl implements GetBatchById {
	
	public GetBatchByIdImpl() {
		
	}
	
	@Override
	public ApiBatchTemplate getBatch(int id){
		ApiBatchTemplate batch = new ApiBatchTemplate();
		try {
			//https://caliber2-mock.revaturelabs.com/mock/training/batch/394
			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch/" + id);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("accept", "application/json");
			connection.connect();
			int respCode = connection.getResponseCode();
			if (respCode != 200) {
			}else {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				ObjectMapper mapper = new ObjectMapper();
				batch = mapper.readValue(inline, ApiBatchTemplate.class);
				
			}
			
		}catch(Exception E) {
			System.out.println("GetBatchById failed");
		}
		
		return batch;
	}

}
