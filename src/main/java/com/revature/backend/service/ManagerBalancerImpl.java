/**
 * This class impelements the method(s) necessary to assign new batches of associates to
 * staging managers, and to ensure that this assignment is done as evenly as possible.
 * 
 * @author Andrew Curry
 */
package com.revature.backend.service;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.model.Manager;

import org.springframework.stereotype.Component;

@Component
public class ManagerBalancerImpl implements ManagerBalancer {

    // ----------
    // INTERFACE METHODS
    // ----------

    /**
     * This method takes the given associates and assigns them to staging
     * managers. It uses the following criteria:
     *  - associates from a given batch should all be assigned to the same manager
     *  - each manager should end up with a (rougly) equivalent amount of associates.
     * 
     * There is no return value; the Associate objects will be updated directly with their
     * assignments.
     * 
     * @param managerMap : should map each Staging Manager to the number of associates
     * they already have assigned to them.
     * @param newAssociates : should be a list of new, unassigned associates. Each
     * of these associates should be in one of the given batches.
     */
    @Override
    public void balanceNewBatches(
        Map<Manager, Integer> managerMap, List<Associate> newAssociates) {
        // Group the associates by batches
        Associate[][] batches = sortIntoBatches(newAssociates);

        // sort batches from largest to smallest
        sortBatchesBySize(batches);

        // assign batches in order, always assigning to the manager with the currently
        // smallest amount of associates
        for (Associate[] batch : batches){
            Manager managerWithLeast = findManagerWithLeast(managerMap);
            // update this manager's count to reflect this new batch
            int oldCount = managerMap.get(managerWithLeast);
            managerMap.put(managerWithLeast, oldCount + batch.length);

            // update each associate with the assignment
            for (Associate associate : batch){
                associate.setManager(managerWithLeast);
            } // end inner for loop (only current batch)
        } // end outer for loop (all batches)
    }

    // ----------
    // HELPER METHODS
    // ----------

    /**
     * Splits a List of associates into batches.
     * 
     * @param associates
     * @return a 2-dimensional array of Associates, where each sub-array contains
     *         all of, and only, the associates from a single batch
     */
    public Associate[][] sortIntoBatches(List<Associate> associates) {
        // TODO
        return null;
    }

    /**
     * Sorts the given 2D array of batches in decreasing order by size
     * (largest array to smallest array).
     * 
     * @param batches
     */
    private void sortBatchesBySize(Associate[][] batches) {
        java.util.Arrays.sort(batches, new java.util.Comparator<Associate[]>() {
            public int compare(Associate[] a, Associate[] b) {
                return Integer.compare(a.length, b.length);
            }
        });
    }

    /**
     * Searches the given map of managers/integers for the manager key with the smallest
     * Integer value (that is, the manager with the least assigned associates).
     * 
     * @param managerMap
     * @return
     */
    private Manager findManagerWithLeast(Map<Manager, Integer> managerMap) {
        return null;
    }
}
