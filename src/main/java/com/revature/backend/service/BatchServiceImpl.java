package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Batch;
import com.revature.backend.repository.BatchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("batchService")
public class BatchServiceImpl implements BatchService {

	@Autowired
    BatchRepository batchRepo;

    @Override
    public List<Batch> getAllBatches() {
        return null;
    }

    @Override
    public List<Batch> saveBatches(List<Batch> bList) {
        // call the appropriate Repo method to save (aka insert) batches into DB
        List<Batch> list = batchRepo.saveAll(bList);
        return list;
    }
    
    public Batch getBatchById(int id) {
    	// TODO call the appropriate Repo method to save (aka insert) batches into DB
    	return batchRepo.findById(id);
    }
    
}
