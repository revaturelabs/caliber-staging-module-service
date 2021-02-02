package com.revature.backend.service;

import java.util.List;
import java.util.Map;

import com.revature.backend.model.Manager;

public interface ManagerService {

  public List<Manager> getAllManagers();

  public List<Manager> saveAll(List<Manager> mList);

  public Map<Manager, Integer> getAllManagersAndAssociates();

}
