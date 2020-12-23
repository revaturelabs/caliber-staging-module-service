package com.revature.backend.service;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;

import com.revature.backend.model.Associate;

@SpringBootConfiguration()
public interface BackendService {

	public List<Associate> findAssociatesByManagerId(int id);

}
