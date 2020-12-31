package com.revature.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.BackendRepo;
import com.revature.backend.service.ManagerService;

@SpringBootTest()
public class ManagerTesting {
	
	@Autowired
	ManagerService managerService;
	
	@Mock
	BackendRepo backendRepo;
	
	@Mock
	Manager manager = new Manager();
	
//	@Rule 
//	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
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
	
	
		
	@Test
	public void testGetAllManagersAndAssociates() {
		Map<Manager, Integer> expectedMockMap = new HashMap<>();
		
		int id = 0;
		List<Associate> associates = backendRepo.findAssociatesByManagerId(id);
		
		int mockAssociateSize = associates.size();
		
		expectedMockMap.put(manager, mockAssociateSize);

		when(backendRepo.findAssociatesByManagerId(id)).thenReturn(associates);
		
			
	
	}
	
	

}
