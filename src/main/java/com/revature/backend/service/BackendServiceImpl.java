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
	
	@Override
	public List<Associate> findAssociatesByManager_Id(int id) {
		return backendRepo.findAssociatesByManager_Id(id);
	}

}
