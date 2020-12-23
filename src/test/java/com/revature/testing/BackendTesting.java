package com.revature.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.service.BackendService;

@SpringBootTest()
class BackendTesting {

	@Autowired
	BackendService backendService;

	@Test
	void contextLoads() {
	}

	int managerid;

	@Test
	void PASSfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(managerid);
		assertNotEquals(0, a.size());
	}

	@Test
	void FAILfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(0);
		assertEquals(0, a.size());
	}

}