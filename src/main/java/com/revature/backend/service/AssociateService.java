package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Associate;

public interface AssociateService {

  public List<Associate> getAllAssociates();

  public List<Associate> saveAssociates(List<Associate> aList);
}
