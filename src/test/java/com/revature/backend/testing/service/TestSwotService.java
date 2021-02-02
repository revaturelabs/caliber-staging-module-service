/**
 * This class contains unit tests for the SwotService class.
 * 
 * @author Andrew Curry
 */
package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.revature.backend.model.AnalysisItem;
import com.revature.backend.model.Swot;
import com.revature.backend.repository.AnalysisItemRepository;
import com.revature.backend.repository.SwotRepository;
import com.revature.backend.service.SwotService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = { SwotService.class })
@RunWith(SpringRunner.class)
public class TestSwotService {

  // ----------
  // SETUP
  // ----------

  @MockBean
  SwotRepository mockSwotRepository;

  @MockBean
  AnalysisItemRepository mockAnalysisItemRepository;

  @Autowired
  SwotService swotService;

  // ----------
  // TESTS
  // ----------

  /**
   * Tests to make sure the analysis items are assigned and saved
   */
  @Test
  public void testCreateNewSwot() {
    Swot input = new Swot(); // ok to leave fields null
    List<AnalysisItem> analysisList = new ArrayList<>();
    for (int i = 0; i < 4; i++)
      analysisList.add(new AnalysisItem());
    input.setAnalysisItems(analysisList);
    when(mockSwotRepository.save(any())).thenReturn(new Swot()); // just not null
    swotService.createNewSwot(input);
    // make sure they're all assigned to the same new swot
    Swot parent = analysisList.get(0).getSwot();
    assertNotNull(parent);
    for (int i = 1; i < analysisList.size(); i++) {
      assertEquals(parent, analysisList.get(i).getSwot());
    }
    verify(mockSwotRepository).save(parent);
  }

  // the other methods are essentially just single calls to the repo
}
