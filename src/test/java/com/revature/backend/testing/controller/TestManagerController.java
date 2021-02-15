package com.revature.backend.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.controller.ManagerController;
import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;
import com.revature.backend.util.ClientMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
/**
 * This is a test for the ManagerController class. It contains 4 tests.
 * Test 1: Tests if the application loads<p>
 * Test 2:<p>
 * Test 3:<p>
 * Test 4:<p>
 * @author ?: wrote tests and initial documentation.
 */
@SpringBootTest
public class TestManagerController {
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Mock
	ManagerService service;
	
	
	private MockMvc mockmvc;
	
	@Autowired
  @InjectMocks
	private ManagerController controller;
	
  @BeforeEach
  public void before(){
    mockmvc=MockMvcBuilders.standaloneSetup(controller).build();
  }
	
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
		
		this.mockmvc.perform(post("/getmanager").
				contentType("application/json")
				.content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com"))))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void verifyResult() throws Exception {
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager(1, "mock@gmail.com", "mock", "manager"));
		
		when(service.getAllManagers()).thenReturn(managers);
		
		ClientMessage expectedResponse = new ClientMessage("4");
		
		MvcResult mvcResult = this.mockmvc.perform(post("/getmanager").
							  contentType("application/json")
							  .content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com"))))
							  .andReturn();
		
		String actualResponse = mvcResult.getResponse().getContentAsString();
		
		assertThat(actualResponse).isEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedResponse));
	}
	
	@Test
	public void verifyFailure() throws Exception {
		List<Manager> managers = new ArrayList<>();
		managers.add(new Manager(2, "mock@gmail.com", "mock", "manager"));
		
		when(service.getAllManagers()).thenReturn(managers);
		
		ClientMessage expectedResponse = new ClientMessage("1");
		
		MvcResult mvcResult = this.mockmvc.perform(post("/getmanager").
							  contentType("application/json")
							  .content(objectMapper.writeValueAsString(new ClientMessage("mock@gmail.com"))))
							  .andReturn();
		
		String actualResponse = mvcResult.getResponse().getContentAsString();
		
		assertThat(actualResponse).isNotEqualToIgnoringWhitespace(objectMapper.writeValueAsString(expectedResponse));
	}
	
}
