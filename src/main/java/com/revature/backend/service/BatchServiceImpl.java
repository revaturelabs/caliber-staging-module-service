package com.revature.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.Batch;
import com.revature.backend.repository.BatchRepository;

@Service("batchService")
public class BatchServiceImpl implements BatchService {

<<<<<<< HEAD
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
    
=======
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

>>>>>>> c375196aafda135eefaa4552dc6c892d4c8f3182
}
