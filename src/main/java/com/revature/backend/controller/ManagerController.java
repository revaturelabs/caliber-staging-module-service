package com.revature.backend.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;
import com.revature.backend.util.ClientMessage;

@RestController
@CrossOrigin("*")
//@CrossOrigin("http://ec2-54-237-27-253.compute-1.amazonaws.com")
public class ManagerController {

  private static Logger log = Logger.getLogger(ManagerController.class);

  @Autowired
  ManagerService managerService;

  @PostMapping("/getmanager")
  public ResponseEntity<ClientMessage> getLoggedInManager(@RequestBody ClientMessage email) {

    List<Manager> allManager = managerService.getAllManagers();
    ResponseEntity<ClientMessage> ret;
    for (Manager m : allManager) {
      if (m.getEmail().equals(email.getMessage())) {
        log.info("Found matching manager!");
        ClientMessage message = new ClientMessage();
        message.setMessage(Integer.toString(m.getId()));
        ret = ResponseEntity.ok(message);
        return ret;
      }
    }
    log.info("No manager found in DB with that email, creating new manager");
    // If here, no manager with email exists in DB, automatically add manager to DB
    Manager m = new Manager(email.getMessage(), "No Data", "No Data");
    allManager.clear();
    allManager.add(m);
    List<Manager> mList = managerService.saveAll(allManager);
    ClientMessage message = new ClientMessage();
    message.setMessage(Integer.toString(mList.get(0).getId()));
    ret = ResponseEntity.ok(message);
    return ret;

  }

}
