package com.revature.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;

@SpringBootTest()
public class ManagerTesting {
	
	@Autowired
	ManagerService managerService;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void PASSfindAllManagers() {
		List<Manager> m = managerService.getAllManagers();
		assertNotEquals(0, m.size());
	}
	
	@Test
	void FAILfindAllManager() {
		List<Manager> m = managerService.getAllManagers();
		assertEquals(0, m.size());
	}

}
