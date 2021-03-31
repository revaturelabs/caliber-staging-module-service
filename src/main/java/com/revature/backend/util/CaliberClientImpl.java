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
		try {
			batch = client.get().uri("/{id}",id).retrieve().bodyToMono(ApiBatchTemplate.class).block();
		}catch(Exception E) {
			System.out.println("GetBatchById failed");
		}
		
		return batch;
	}

}
