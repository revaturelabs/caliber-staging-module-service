package com.revature.backend.testing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.backend.controller.SwotController;
import com.revature.backend.model.AnalysisItem;
import com.revature.backend.model.AnalysisType;
import com.revature.backend.model.Associate;
import com.revature.backend.model.Manager;
import com.revature.backend.model.Swot;
import com.revature.backend.service.SwotService;

@SpringBootTest
public class SwotControllerTests {

	ObjectMapper objectMapper = new ObjectMapper();
	
	@InjectMocks
	SwotController swotController;
	
	private MockMvc mockMvc;
	
	@Mock
	private SwotService service;
	
	/*
	 * Create a Swot object with an ID.
	 * This is obviously a lot of data and is more going
	 * to be a template, fit to change in the future.
	 */
	
	//initalizing global variables for easy access
	List<AnalysisItem> mockAnalysisItems = new ArrayList<>();
	List<Swot> swots = new ArrayList<>();
	Associate associate = new Associate(1, null, null, null, null, null, null, null);
	Manager manager = new Manager(1, null, null, null);
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	
	//seting up a mock swot with an id of 1
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(swotController).build();
		AnalysisItem mockAI1 = new AnalysisItem(1, "Strength", null, AnalysisType.STRENGTH);
		AnalysisItem mockAI2 = new AnalysisItem(2, "Weakness", null, AnalysisType.WEAKNESS);
		AnalysisItem mockAI3 = new AnalysisItem(3, "Opportunity", null, AnalysisType.OPPORTUNITY);
		AnalysisItem mockAI4 = new AnalysisItem(4, "Threat", null, AnalysisType.THREAT);
		
		mockAnalysisItems.add(mockAI1);
		mockAnalysisItems.add(mockAI2);
		mockAnalysisItems.add(mockAI3);
		mockAnalysisItems.add(mockAI4);
		
		Swot mockSwot1 =  new Swot(1, associate, manager, timestamp, timestamp, "");
		Swot mockSwot2 =  new Swot(2, associate, manager, timestamp, timestamp, "");
		mockSwot1.setAnalysisItems(mockAnalysisItems);
		mockSwot2.setAnalysisItems(mockAnalysisItems);
		swots.add(mockSwot1);
		swots.add(mockSwot2);
		
		when(service.retrieveAllSwot()).thenReturn(swots);
	}

	/*
	 * Sanity Check - Ensure the application context
	 * is loaded before moving on to the other tests.
	 */
	@Test
	public void contextLoads() throws Exception{
		assertThat(swotController).isNotNull();
	}
	
	/*
	 * Verify that the HTTP status is 200 - OK
	 * for a basic GET request with no parameters. 
	 */
	@Test
	public void controllerSuccess() throws Exception {	
		this.mockMvc.perform(get("/swot/view/all")).andDo(print()).andExpect(status().isOk());
	}
}
