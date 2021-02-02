package com.revature.backend.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.revature.backend.controller.ManagerController;
import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;
import com.revature.backend.util.ClientMessage;

@WebMvcTest(ManagerController.class)
public class TestManagerController {

  ObjectMapper objectMapper = new ObjectMapper();

  @MockBean
  ManagerService service;

  @Autowired
  private MockMvc mockmvc;

  @Autowired
  private ManagerController controller;

  /*
   * Sanity Check - if this fails, application context is not loaded and all other
   * tests should fail
   */
  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }

  @Test
  public void verifyListening() throws Exception {
    List<Manager> managers = new ArrayList<>();
    managers.add(new Manager(1, "mock@gmail.com", "mock", "manager"));

    when(service.getAllManagers()).thenReturn(managers);

    this.mockmvc
        .perform(post("/getmanager").contentType("application/json")
            .content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com"))))
        .andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void verifyResult() throws Exception {
    List<Manager> managers = new ArrayList<>();
    managers.add(new Manager(1, "mock@gmail.com", "mock", "manager"));

    when(service.getAllManagers()).thenReturn(managers);

    ClientMessage expectedResponse = new ClientMessage("1");

    MvcResult mvcResult = this.mockmvc.perform(post("/getmanager").contentType("application/json")
        .content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com")))).andReturn();

    String actualResponse = mvcResult.getResponse().getContentAsString();

    assertThat(actualResponse).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedResponse));
  }

  @Test
  public void verifyFailure() throws Exception {
    List<Manager> managers = new ArrayList<>();
    managers.add(new Manager(2, "mock@gmail.com", "mock", "manager"));

    when(service.getAllManagers()).thenReturn(managers);

    ClientMessage expectedResponse = new ClientMessage("1");

    MvcResult mvcResult = this.mockmvc.perform(post("/getmanager").contentType("application/json")
        .content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com")))).andReturn();

    String actualResponse = mvcResult.getResponse().getContentAsString();

    assertThat(actualResponse).isNotEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedResponse));
  }

}
