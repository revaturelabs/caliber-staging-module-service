package com.revature.backend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.Associate;
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.repository.BackendRepository;
import com.revature.backend.util.GetBatchById;

@Service("backendService")
public class BackendServiceImpl implements BackendService {

  @Autowired
  BackendRepository backendRepo;
  @Autowired
  GetBatchById batchRetriever;

  /**
   * This method takes the managers id and returns all associates assigned to him.
   * 
   * The return value is a list of all associates assigned to the managers id
   * number.
   * 
   * @param id : should be a valid id assigned to a manager.
   * 
   * @author Mareo Yapp
   */
  @Override
  public List<Associate> findAssociatesByManagerId(int id) {
    try {
      return backendRepo.findAssociatesByManagerId(id);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * This method takes the managers id and returns all associates assigned and
   * graduated to staging in the last 7 days.
   * 
   * The return value is a list of all associates assigned to the managers id
   * number.
   * 
   * @param id : should be a valid id assigned to a manager.
   */
  @Override
  public List<Associate> findNewAssociatesByManagerId(int id) {
    Set<Integer> hashS = new HashSet<Integer>();
    List<Associate> ret = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate ld = LocalDate.now();

    try {
      System.out.println("test");
      List<Associate> associates = backendRepo.findAssociatesByManagerId(id);

      // Make only unique batch id calls to make backend faster
      for (Associate a : associates) {
        hashS.add(a.getBatch().getId());
      }
      for (int x : hashS) {
        ApiBatchTemplate batch = batchRetriever.getBatch(x);
        LocalDate bd = LocalDate.parse(batch.getEndDate(), formatter);
        long elapsedDays = ChronoUnit.DAYS.between(bd, ld);
        if (elapsedDays <= 7) {
          System.out.println(elapsedDays);
          for (Associate a : associates) {
            if (a.getBatch().getId() == x) {
              ret.add(a);
            }
          }
        }
      }
      // Non unique calls
      /*
       * for (Associate a: associates) { ApiBatchTemplate batch
       * =batchRetriever.getBatch(a.getBatch().getId()); LocalDate bd =
       * LocalDate.parse(batch.getEndDate(), formatter); long elapsedDays =
       * ChronoUnit.DAYS.between(bd, ld); if(elapsedDays<= 7) { ret.add(a); } }
       */

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    // Test to show it works

    /*
     * int batchId = 394; ApiBatchTemplate batch =batchRetriever.getBatch(batchId);
     * 
     * 
     * LocalDate bd = LocalDate.parse(batch.getEndDate(), formatter);
     * System.out.println("Batch End "+ bd); System.out.println("Today "+ ld);
     * 
     * 
     * long elapsedDays = ChronoUnit.DAYS.between(bd, ld);
     * System.out.println("days elapsed "+ elapsedDays);
     */
    return ret;
  }

}
