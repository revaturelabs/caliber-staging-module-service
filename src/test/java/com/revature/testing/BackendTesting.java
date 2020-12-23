package com.revature.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.service.BackendService;

@SpringBootTest
class BackendTesting {
	
	@Autowired
	BackendService backendService;

	@Test
	void contextLoads() {
	}
	
	int managerid;
	
	@Test
	void PASSfindAssociatesByManager_Id() {
		List<Associate> a = backendService.findAssociatesByManager_Id(managerid);
		assertNotEquals(0, a.size());
	}
	
	@Test
	void FAILfindAssociatesByManager_Id() {
		List<Associate> a = backendService.findAssociatesByManager_Id(0);
		assertEquals(0, a.size());
	}

}
