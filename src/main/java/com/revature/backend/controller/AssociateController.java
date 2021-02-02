package com.revature.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.backend.model.Associate;
import com.revature.backend.model.dto.AssociateDTO;
import com.revature.backend.service.BackendService;

@RestController
@CrossOrigin("*")
//@CrossOrigin("http://ec2-54-237-27-253.compute-1.amazonaws.com")
public class AssociateController {

  @Autowired
  BackendService backendService;

  @GetMapping("/associates")
  public ResponseEntity<List<AssociateDTO>> getAssociates(@RequestParam int manager) {
    ResponseEntity<List<AssociateDTO>> ret;
    List<AssociateDTO> body = null;
    List<Associate> associates = backendService.findAssociatesByManagerId(manager);

    if (associates == null || associates.size() == 0) {
      ret = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } else {
      body = new ArrayList<>();
      for (Associate a : associates) {
        body.add(new AssociateDTO(a));
      }
      ret = ResponseEntity.ok(body);
    }
    return ret;
  }

  /**
   * Given a manager id, will return associates assigned to that manager and have
   * enter staging in the last 7 days.
   * 
   * @param manager
   * @return
   */

  @GetMapping("/associates/new")
  public ResponseEntity<List<AssociateDTO>> getNewAssociates(@RequestParam int manager) {
    ResponseEntity<List<AssociateDTO>> ret = null;
    List<AssociateDTO> body = null;
    List<Associate> associates = backendService.findNewAssociatesByManagerId(manager);
    if (associates == null || associates.size() == 0) {
      ret = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } else {

      body = new ArrayList<>();
      for (Associate a : associates) {
        body.add(new AssociateDTO(a));
      }
      ret = ResponseEntity.ok(body);

    }
    return ret;

  }

}
