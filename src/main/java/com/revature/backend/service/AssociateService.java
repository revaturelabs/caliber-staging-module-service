package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Associate;

import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration()
public interface AssociateService {

	public List<Associate> getAllAssociates();
	public void saveAssociates(List<Associate> aList);
}
