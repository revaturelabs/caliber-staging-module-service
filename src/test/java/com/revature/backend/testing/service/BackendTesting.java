package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.service.BackendService;

@SpringBootTest()
class BackendTesting {

	@Autowired
	private BackendService backendService;

	@Test
	void contextLoads() {
	}

	int managerid=1;

	@Ignore
	@Test
	public void PASSfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(managerid);
		assertNotEquals(0, a.size());
		System.out.println(a);
	}

	@Test
	public void FAILfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(0);
		assertEquals(0, a.size());
	}

}