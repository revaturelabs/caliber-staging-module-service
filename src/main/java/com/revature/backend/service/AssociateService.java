package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Associate;


public interface AssociateService {

	public List<Associate> getAllAssociates();
	public void saveAssociates(List<Associate> aList);
}
