package com.revature.backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.BackendRepo;
import com.revature.backend.repository.ManagerRepository;
import com.revature.backend.service.ManagerService;
import com.revature.backend.service.ManagerServiceImpl;

@SpringBootTest(classes = {ManagerService.class, ManagerServiceImpl.class})
@RunWith(SpringRunner.class)
public class ManagerTesting {
	
	@MockBean
	BackendRepo mockBackendRepo;
	
	@MockBean
	ManagerRepository mockManagerRepository;

	@Autowired
	ManagerService managerService;
	
	/**
	 * Tests that managerService behaves properly when the repo finds some manager(s)
	 */
	@Test
	void findAllManagers() {
		List<Manager> expected = new ArrayList<>();
		expected.add(new Manager());
		when(mockManagerRepository.findAllManagers()).thenReturn(expected);
		List<Manager> actual = managerService.getAllManagers();
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that managerService behaves properly when the repo throws an exception
	 */
	@Test
	void findAllManagerFail() {
		List<Manager> found = new ArrayList<>(); // none found
		when(mockManagerRepository.findAllManagers())
			.thenThrow(new ArrayIndexOutOfBoundsException()); // arbitrary type
		List<Manager> m = managerService.getAllManagers();
		assertNull(m);
	}
		
	@Test
	public void testGetAllManagersAndAssociates() {
		Map<Manager, Integer> expectedMockMap = new HashMap<>();
		
		int id = 0;
		List<Associate> associates = mockBackendRepo.findAssociatesByManagerId(id);
		
		int mockAssociateSize = associates.size();
		
		expectedMockMap.put(new Manager(), mockAssociateSize);

		when(mockBackendRepo.findAssociatesByManagerId(id)).thenReturn(associates);
		
			
	
	}
	
	

}
