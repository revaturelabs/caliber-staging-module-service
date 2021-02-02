package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
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
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.repository.BackendRepository;
import com.revature.backend.service.BackendService;
import com.revature.backend.service.BackendServiceImpl;
import com.revature.backend.util.GetBatchById;

@SpringBootTest()
class BackendTesting {

  @Mock
  BackendRepository repo;

  @Mock
  GetBatchById getbatch;

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

  int managerid = 1;

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
   * Tests logic in BackendServiceImpl.findNewAssociatesByManagerId() Mocking
   * logic of GetBatchById logic. Ensures that only associates whose batch ended
   * within the last 7 days gets returned. Creates a mock batch to be returned
   * that has an end date of LocalDateTime.now()
   * 
   */
  @SuppressWarnings("deprecation")
  @Test
  public void findNewAssociates() {

    MockitoAnnotations.initMocks(this);
    List<Associate> associates = new ArrayList<>();
    associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(1, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));
    associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(2, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));

    Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));

    // create a mock batch ending within the last 7 days
    ApiBatchTemplate newBatch = new ApiBatchTemplate();
    newBatch.setId(1);
    newBatch.setEndDate(LocalDate.now().toString());

    // create a mock batch ending beyond the last 7 days
    ApiBatchTemplate oldBatch = new ApiBatchTemplate();
    oldBatch.setId(2);
    oldBatch.setEndDate("2020-10-10");

    Mockito.when(getbatch.getBatch(1)).thenReturn(newBatch);
    Mockito.when(getbatch.getBatch(2)).thenReturn(oldBatch);

    List<Associate> expected = backend.findNewAssociatesByManagerId(1);

    // assert that only the 1 associate is returned
    assertEquals(1, expected.size());
    verify(repo, times(1)).findAssociatesByManagerId(1);

  }

  /*
   * Tests that multiple associates will be returned if from the same batch that
   * ended today
   * 
   */
  @SuppressWarnings("deprecation")
  @Test
  public void findNewAssociatesMultiple() {
    MockitoAnnotations.initMocks(this);
    List<Associate> associates = new ArrayList<>();
    associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(1, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));
    associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(1, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));

    Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));

    ApiBatchTemplate newBatch = new ApiBatchTemplate();
    newBatch.setId(1);
    newBatch.setEndDate(LocalDate.now().toString());

    Mockito.when(getbatch.getBatch(1)).thenReturn(newBatch);

    List<Associate> expected = backend.findNewAssociatesByManagerId(1);

    // assert that both associates are returned
    assertEquals(2, expected.size());
    verify(repo, times(1)).findAssociatesByManagerId(1);

  }

  /*
   * Tests that the list returned of associates will be empty if they are not
   * apart of batches that ended within the last 7 days.
   */
  @SuppressWarnings("deprecation")
  @Test
  public void findNewAssociatesFail() {
    MockitoAnnotations.initMocks(this);
    List<Associate> associates = new ArrayList<>();
    associates.add(new Associate(1, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(2, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));
    associates.add(new Associate(2, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(2, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING));

    ApiBatchTemplate oldBatch = new ApiBatchTemplate();
    oldBatch.setId(2);
    oldBatch.setEndDate("2020-10-10");

    Mockito.when(repo.findAssociatesByManagerId(1)).thenReturn((associates));
    Mockito.when(getbatch.getBatch(2)).thenReturn(oldBatch);
    List<Associate> expected = backend.findNewAssociatesByManagerId(1);

    // assert that no associates are returned
    assertEquals(0, expected.size());
    verify(repo, times(1)).findAssociatesByManagerId(1);

  }

}