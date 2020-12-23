package com.revature.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.backend.model.Associate;
import com.revature.backend.repo.repo;

@SpringBootTest
class CaliberApplicationTests {
	
	@Autowired
	repo managerService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void PASSfindAssociatesByManager_Id() {
		List<Associate> a = managerService.findAssociatesByManager_Id(5);
		assertNotEquals(0, a.size());
	}
	
	@Test
	void FAILfindAssociatesByManager_Id() {
		List<Associate> a = managerService.findAssociatesByManager_Id(0);
		assertEquals(0, a.size());
	}

}
