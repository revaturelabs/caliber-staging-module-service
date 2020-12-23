package com.revature.backend.service;

import java.util.List;

import com.revature.backend.model.Associate;

public interface BackendService {

	public List<Associate> findAssociatesByManager_Id(int id);

}
