package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.model.AssociateStatus;
import com.revature.backend.model.Batch;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.BackendRepo;
import com.revature.backend.service.BackendService;
import com.revature.backend.service.BackendServiceImpl;

@SpringBootTest()
class BackendTesting {

	@Mock
	BackendRepo repo;
	
	@Autowired
	private BackendService backendService;

	@Autowired
	@InjectMocks
	private BackendServiceImpl backend;
	
	@Before
	@SuppressWarnings("deprecation")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void contextLoads() {
	}

	int managerid=1;

	/**
	 * Tests logic in the BackendServiceImpl.findAssociatesByManagerId()
	 * 
	 * Ensures that only associates assigned to the manager's id are returned.
	 * 
	 * The test assumes that a manager will always have at least one associate
	 * assigned to him or her.
	 * 
	 * The test uses assertFalse to test if the list is not empty.
	 * 
	 * @author Mareo Yapp
	 */
	@Test
	public void PASSfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(managerid);
		assertFalse(a.isEmpty());
	}

	/**
	 * Tests logic in the BackendServiceImpl.findAssociatesByManagerId()
	 * 
	 * Ensures that if the manager id does not exists on the database then a empty
	 * list is return
	 * 
	 * The test uses assertTrue to test if the list is empty.
	 * 
	 * @author Mareo Yapp
	 */
	@Test
	public void FAILfindAssociatesByManagerId() {
		List<Associate> a = backendService.findAssociatesByManagerId(0);
		assertTrue(a.isEmpty());
	}
	
	
	
	/*
	 * Tests logic in BackendServiceImpl.findNewAssociatesByManagerId()
	 * encompassing testing of GetBatchById logic.
	 * Ensures that only associates whose batch ended within the last 7
	 * days gets returned.
	 * 
	 * At this time, Batch ID 547 must be changed every week in order to
	 * get a successful test. Change 547 to batch ID that has ended within
	 * the last week.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void findNewAssociates() {
		MockitoAnnotations.initMocks(this);
		List<Associate> associates = new ArrayList<>();
		associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(547, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(546, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		
		Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));
		List<Associate> expected = backend.findNewAssociatesByManagerId(1);
		
		assertEquals(1, expected.size());
		verify(repo, times(1)).findAssociatesByManagerId(1);
		
	}
	
	
	/*
	 * Tests that multiple associates will be returned if from the
	 * same batch
	 * 
	 * Change 547 to Batch ID that has ended within the last week
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void findNewAssociatesMultiple() {
		MockitoAnnotations.initMocks(this);
		List<Associate> associates = new ArrayList<>();
		associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(547, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(547, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		
		Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));
		List<Associate> expected = backend.findNewAssociatesByManagerId(1);
		
		assertEquals(2, expected.size());
		verify(repo, times(1)).findAssociatesByManagerId(1);
		
	}
	
	/*
	 * Tests that the list returned of associates will be empty
	 * if they are not apart of batches that ended within the 
	 * last 7 days.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void findNewAssociatesFail() {
		MockitoAnnotations.initMocks(this);
		List<Associate> associates = new ArrayList<>();
		associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(546, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
				new Manager(1, "manager@manager.com", "Demo", "Manager"),
				new Batch(546, "salesID", "name", "skill", "location"), AssociateStatus.STAGING));
		
		Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));
		List<Associate> expected = backend.findNewAssociatesByManagerId(1);
		
		assertEquals(0, expected.size());
		verify(repo, times(1)).findAssociatesByManagerId(1);
		
	}

}