package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Associate;

/**
 * This interface describes the methods necessary for a manager to retrieve all
 * associates assigned to him.
 * 
 * @author Mareo Yapp
 */
public interface BackendService {

  /**
   * This method takes the managers id and returns all associates assigned to him.
   * 
   * The return value is a list of all associates assigned to the managers id
   * number.
   * 
   * @param id : should be a valid id assigned to a manager.
   * 
   * @author Mareo Yapp
   */
  public List<Associate> findAssociatesByManagerId(int id);

  public List<Associate> findNewAssociatesByManagerId(int manager);

}
