package com.revature.backend.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.controller.AssociateController;
import com.revature.backend.model.Associate;
import com.revature.backend.model.AssociateStatus;
import com.revature.backend.model.Batch;
import com.revature.backend.model.Manager;
import com.revature.backend.model.dto.AssociateDTO;
import com.revature.backend.service.BackendService;

@WebMvcTest(AssociateController.class)
public class AssociateControllerTests {

  ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  AssociateController associateController;

  @Autowired
  private MockMvc mockmvc;

  @MockBean
  private BackendService service;

  /*
   * create an Associate object with a unique ID
   */
  private Associate mockAssociate(int id) {
    return new Associate(id, "salesID", "email@email.com", "John", "Doe",
        new Manager(1, "manager@manager.com", "Demo", "Manager"), new Batch(1, "salesID", "name", "skill", "location"),
        AssociateStatus.STAGING);
  }

  private AssociateDTO mockDTO(int id) {
    return new AssociateDTO(id, "salesID", "email@email.com", "John", "Doe", 1, 1, AssociateStatus.STAGING.toString());
  }

  /*
   * Sanity Check - if this fails, application context is not loaded and all other
   * tests should fail
   */
  @Test
  public void contextLoads() throws Exception {
    assertThat(associateController).isNotNull();
  }

  /*
   * Verifies the HTTP Status for a successful response
   */
  @Test
  public void controllerSuccess() throws Exception {
    List<Associate> serviceRet = new ArrayList<>();
    serviceRet.add(mockAssociate(1));
    serviceRet.add(mockAssociate(2));

    when(service.findAssociatesByManagerId(1)).thenReturn(serviceRet);

    this.mockmvc.perform(get("/associates").param("manager", "1")).andDo(print()).andExpect(status().isOk());
  }

  /*
   * Verifies the ResponseBody content for a successful response
   */
  @Test
  public void controllerSuccessContentVerification() throws Exception {
    List<Associate> serviceRet = new ArrayList<>();
    serviceRet.add(mockAssociate(1));
    serviceRet.add(mockAssociate(2));
    List<AssociateDTO> expectedResponse = new ArrayList<>();
    expectedResponse.add(mockDTO(1));
    expectedResponse.add(mockDTO(2));

    when(service.findAssociatesByManagerId(1)).thenReturn(serviceRet);

    MvcResult mvcResult = this.mockmvc.perform(get("/associates").param("manager", "1")).andReturn();
    String actualResponse = mvcResult.getResponse().getContentAsString();

    assertThat(actualResponse).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedResponse));

  }

  /*
   * Verifies HTTP Status for a null return value from the service layer
   */
  @Test
  public void controllerFailReceivesNull() throws Exception {
    when(service.findAssociatesByManagerId(1)).thenReturn(null);

    this.mockmvc.perform(get("/associates").param("manager", "1")).andDo(print()).andExpect(status().isNoContent());
  }

  /*
   * Verifies HTTP Status for an empty list returned from the service layer
   */
  @Test
  public void controllerFailReceivesEmpty() throws Exception {
    List<Associate> serviceRet = new ArrayList<>();
    when(service.findAssociatesByManagerId(1)).thenReturn(serviceRet);

    this.mockmvc.perform(get("/associates").param("manager", "1")).andDo(print()).andExpect(status().isNoContent());
  }

  /*
   * Verifies HTTP Status for a non integer parameter value
   */
  @Test
  public void controllerFailWrongParamType() throws Exception {

    this.mockmvc.perform(get("/associates").param("manager", "string")).andDo(print())
        .andExpect(status().isBadRequest());
  }

  /*
   * Verifies HTTP Status where parameter name is not 'manager'
   */
  @Test
  public void controllerFailWrongParamName() throws Exception {

    this.mockmvc.perform(get("/associates").param("associate", "1")).andDo(print()).andExpect(status().isBadRequest());
  }

}
