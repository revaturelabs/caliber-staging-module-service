package com.revature.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.Associate;
import com.revature.backend.repository.BackendRepo;

@Service("backendService")
public class BackendServiceImpl implements BackendService {

	@Autowired
	BackendRepo backendRepo;

	/**
	 * This method takes the managers id and returns all associates assigned to him.
	 * 
	 * The return value is a list of all associates assigned to the managers id
	 * number.
	 * 
	 * @param id : should be a valid id assigned to a manager.
	 */
	@Override
	public List<Associate> findAssociatesByManagerId(int id) {
		try {
			return backendRepo.findAssociatesByManagerId(id);
		} catch (Exception e) {
			return null;
		}
	}

}
