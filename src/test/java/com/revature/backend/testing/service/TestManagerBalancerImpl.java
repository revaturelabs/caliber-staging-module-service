/**
 * This file contains unit tests for the ManagerBalancer interface and its implementing 
 * class, ManagerBalancerImpl
 * 
 * @author Andrew Curry
 */
package com.revature.backend.testing.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.service.ManagerBalancer;
import com.revature.backend.service.ManagerBalancerImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = { ManagerBalancer.class, ManagerBalancerImpl.class })
@RunWith(SpringRunner.class)
public class TestManagerBalancerImpl {

    // ----------
    // SETUP
    // ----------

    // @Autowired
    // private ManagerBalancer managerBalancer;

    // this isn't the Spring way of doing things, but this seemed like the best compromise
    // solution to a problem I was having. Let me know if you have objections/answers
    // - Andrew
    private ManagerBalancerImpl managerBalancer;

    @Before
    public void setUp() {
        managerBalancer = new ManagerBalancerImpl();
    }

    // ----------
    // TESTS
    // ----------

    // ----------
    // groupIntoBatches() TESTS
    // ----------

    /**
     * Tests a few different possibilities, expecting success in all of them
     */
    @Test
    public void testGroupIntoBatches(){
        testGroupIntoBatchesHelper(new int[] {});
        testGroupIntoBatchesHelper(new int[] {5, 7, 1});
        testGroupIntoBatchesHelper(new int[] {7, 5, 1});
        testGroupIntoBatchesHelper(new int[] {4, 4, 4, 3, 2, 1});
        testGroupIntoBatchesHelper(new int[] {9, 18, 17, 1, 2, 3});
    }

    // ----------
    // sortBatchesBySize() TESTS
    // ----------

    /**
     * Tests a few different possibilities, expecting success in all of them
     */
    @Test
    public void testSortBatchesBySize() {
        testSortBatchesBySizeHelper(new int[] {});
        testSortBatchesBySizeHelper(new int[] { 5, 7, 1});
        testSortBatchesBySizeHelper(new int[] { 7, 5, 1});
        testSortBatchesBySizeHelper(new int[] { 5, 7, 1, 4 });
        testSortBatchesBySizeHelper(new int[] { 5, 7, 1, 4, 3, 18, 20, 55 });
        testSortBatchesBySizeHelper(new int[] { 15, 18, 20, 55 });
    }

    // ----------
    // HELPER METHODS
    // ----------

    // ----------
    // groupIntoBatches() HELPERS
    // ----------

    /**
     * Builds a List of mock associates (which are placed in batches, each batch sized
     * according to a size from sizes), and then verifies that groupIntoBatches splits
     * them up correctly. The order of the mock list will be random.
     * 
     * @param lengths
     */
    public void testGroupIntoBatchesHelper(int[] sizes){
        List<Associate> associateList = generateAssociateList(sizes);
        Associate[][] groupedAssociates = managerBalancer.groupIntoBatches(associateList);
        areAssociatesGroupedCorrectly(groupedAssociates, sizes);
    }

	/**
     * Generates a randomly-ordered list of associates, where associates are grouped into
     * batches, where each batch is sized according to a size from sizes
     */
    private List<Associate> generateAssociateList(int[] sizes) {
        List<Associate> associateList = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++){
            Batch b = new Batch();
            b.setName("" + i);
            int size = sizes[i];
            for (int x = 0; x < size; x++){
                Associate a = new Associate();
                a.setBatch(b);
                associateList.add(a);
            }// end inner for loop
        } // end outer for loop

        Collections.shuffle(associateList); // randomizes order
        return associateList;
    }

    /**
     * Determines if the given 2-d array of associates is correctly grouped into batches;
     * that is, each sub-array contains associates from exactly one batch.
     * The sizes array will be used to verify that the batches are of the correct size
     * (eg, that all of the associates were included and were not modified)
     */
    private boolean areAssociatesGroupedCorrectly(
        Associate[][] groupedAssociates, int[] sizes) {
        
        assertEquals(sizes.length, groupedAssociates.length);
        for (Associate[] group : groupedAssociates){
            if (group.length == 0) continue; // shouldn't happen?
            Batch b = group[0].getBatch();
            int batchIndex = Integer.parseInt(b.getName()); // i set up the names this way
            assertEquals(sizes[batchIndex], group.length);
            // now make sure every associate in this group is in batch b
            for (int i = 1; i < group.length; i++){
                Associate a = group[i];
                assertEquals(a.getBatch().getName(), b.getName());
            }
        }
		return true; // no problems found
	}

    // ----------
    // sortBatchesBySize() HELPERS
    // ----------

    /**
     * Builds a mock group of batches (each batch sized according to a length from 
     * lengths), and then tests to make sure the managerBalancerImpl sorts it correctly.
     * 
     * @param lengths
     */
    private void testSortBatchesBySizeHelper(int[] lengths) {
        Associate[][] testBatches = buildTestBatches(lengths);
        managerBalancer.sortBatchesBySize(testBatches);
        assertTrue(areBatchesSortedBySize(testBatches));
    }

    /**
     * Builds a 2D-array of test/mock associates, where the length of each child
     * array is equal to the corresponding int in lengths.
     * 
     * The associates will be assigned to mock batches, but all other fields will be
     * left blank.
     */
    private Associate[][] buildTestBatches(int[] lengths) {
        Associate[][] testBatches = new Associate[lengths.length][];
        for (int x = 0; x < lengths.length; x++) {
            int L = lengths[x];
            Associate[] batchArray = new Associate[L];
            Batch mockBatch = new Batch();
            mockBatch.setName("batch" + x);
            for (int i = 0; i < L; i++) {
                batchArray[i] = new Associate();
                batchArray[i].setBatch(mockBatch);
            }
            testBatches[x] = batchArray;
        }
        return testBatches;
    }

    /**
     * Determines if the given 2-d array of associates is sorted in decreasing order of
     * size (largest batches first, smallest last)
     * 
     * @param batches
     * @return
     */
    private boolean areBatchesSortedBySize(Associate[][] batches) {
        if (batches.length < 2) return true; // trivially true
        int lastLength = batches[0].length;
        for (int i = 1; i < batches.length; i++){
            int currentLength = batches[i].length;
            if (currentLength > lastLength) return false;
            else lastLength = currentLength;
        }
        return true; // if no problems, it's sorted
    }
}
