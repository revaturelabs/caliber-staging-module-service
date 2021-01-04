/**
 * This class contains unit tests for the SwotService class.
 * 
 * @author Andrew Curry
 */
package com.revature.backend.testing.service;

import com.revature.backend.repository.AnalysisItemRepository;
import com.revature.backend.repository.SwotRepository;
import com.revature.backend.service.SwotService;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SwotService.class})
@RunWith(SpringRunner.class)
public class TestSwotService {
    
    // ----------
    // SETUP
    // ----------

    @MockBean
    SwotRepository mockSwotRepository;

    @MockBean
    AnalysisItemRepository mockAnalysisItemRepository;
}
