package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Batch;

public interface BatchService {

  public List<Batch> getAllBatches();

  public List<Batch> saveBatches(List<Batch> bList);

}
