package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
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
	
	
	
	/*
	 * Tests logic in BackendServiceImpl.findNewAssociatesByManagerId()
	 * encompassing testing of GetBatchById logic
	 * 
	 * At this time, Batch ID 547 must be changed every week in order to
	 * get a successful test. Change 547 to batch ID that has ended within
	 * the last week.
	 */
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
	 * Change 547 to Batch ID that has ended within the last week
	 */
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