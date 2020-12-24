/**
 * This file contains unit tests for the ManagerBalancer interface and its implementing 
 * class, ManagerBalancerImpl
 * 
 * @author Andrew Curry
 */
package com.revature.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.service.ManagerBalancer;
import com.revature.backend.service.ManagerBalancerImpl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import io.micrometer.core.instrument.distribution.FixedBoundaryVictoriaMetricsHistogram;

@SpringBootTest(classes={ManagerBalancer.class, ManagerBalancerImpl.class})
@RunWith(SpringRunner.class)
public class TestManagerBalancer {

    // ----------
    // SETUP
    // ----------

    @Autowired
    private ManagerBalancer managerBalancer;

    // ----------
    // TESTS
    // ----------

    // ----------
    // sortBatchesBySize() TESTS
    // ----------

    /**
     * Tests a few different possibilities, expecting success in all of them
     */
    @Test
    public void testSortBatchesBySize(){
        //Associate[][] testBatches = buildTestBatches({5, 7, 1, 4});
    }

    // ----------
    // HELPER METHODS
    // ----------

    /**
     * Builds a 2D-array of test/mock associates, where the length of each child array is
     * equal to the corresponding int in lengths.
     * 
     * The associates will be assigned to mock batches, but all other fields will be left
     * blank. 
     */
    public Associate[][] buildTestBatches(int[] lengths){
        Associate[][] testBatches = new Associate[lengths.length][];
        for (int L : lengths){
            Associate[] batchArray = new Associate[L];
            Batch mockBatch = new Batch();
            for (int i = 0; i < L; i++){
                batchArray[i] = new Associate();
                batchArray[i].setBatch(mockBatch);
            }
        }
        return testBatches;
    }
}
