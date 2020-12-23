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
	 * This method takes the managers id number and returns a list of all associates assigned to him.
	 */
	@Override
	public List<Associate> findAssociatesByManagerId(int id) {
		return backendRepo.findAssociatesByManagerId(id);
	}

}
