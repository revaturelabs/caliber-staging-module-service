package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Batch;

import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration()
public interface BatchService {

	public List<Batch> getAllBatches();
	public void saveBatches(List<Batch> bList);

}
