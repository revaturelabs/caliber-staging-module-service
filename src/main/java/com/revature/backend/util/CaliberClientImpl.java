package com.revature.backend.util;

import java.net.HttpURLConnection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.model.api.ApiBatchTemplate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class will handle retrieving a batch by id from the Caliper
 * API.
 * 
 * getBatch(): returns a batch object associated with the id paramater
 * 
 * @author Suva Shahria
 **/
@Component
public class CaliberClientImpl implements CaliberClient {
	private WebClient client = WebClient.create("https://caliber2-mock.revaturelabs.com/mock/training/batch");
	
	public CaliberClientImpl() {
		
	}
	
	@Override
	public ApiBatchTemplate getBatch(int id){
		ApiBatchTemplate batch = new ApiBatchTemplate();
		//System.out.println("in getBatch "+ id);
		try {
			batch = client.get().uri("/{id}",id).retrieve().bodyToMono(ApiBatchTemplate.class).block();
			//System.out.println(batch.toString());
			//batch = result.block();
			//batch = result.map(null);
//			System.out.println("in try");
//			//https://caliber2-mock.revaturelabs.com/mock/training/batch/394
//			URL url = new URL("https://caliber2-mock.revaturelabs.com/mock/training/batch/" + id);
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");
//			connection.setRequestProperty("accept", "application/json");
//			connection.connect();
//			int respCode = connection.getResponseCode();
//			if (respCode != 200) {
//				System.out.println("respCode "+ respCode);
//				//throw new RuntimeException("HttpResonseCode: " + respCode);
//			}else {
//				//System.out.println("connected");
//				String inline = "";
//				Scanner sc = new Scanner(url.openStream());
//				while (sc.hasNext()) {
//					inline += sc.nextLine();
//				}
//				sc.close();
////				System.out.println(inline);
//				ObjectMapper mapper = new ObjectMapper();
//				batch = mapper.readValue(inline, ApiBatchTemplate.class);
				
//			}
			
		}catch(Exception E) {
			System.out.println("GetBatchById failed");
		}
		
		return batch;
	}

}
