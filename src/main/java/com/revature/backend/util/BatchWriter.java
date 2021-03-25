package com.revature.backend.util;

import java.util.List;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;

public interface BatchWriter {
    List<Batch> writeNewlyStagingBatches(List<Batch> bList);
    List<Associate> writeNewlyStagingAssociates(List<Associate> aList);
}
