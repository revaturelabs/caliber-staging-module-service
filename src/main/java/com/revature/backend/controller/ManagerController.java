package com.revature.backend.controller;

import java.util.List;

import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	private final ManagerService managerService;

  public ManagerController(ManagerService managerService) {
    this.managerService = managerService;
  }

	@PostMapping
	public ResponseEntity<String> getLoggedInManager(@RequestBody String email) {
    String managerId =
        Integer.toString(managerService.getManagerByEmail(email).getId());
    return new ResponseEntity<>(managerId, HttpStatus.OK);
	}
}
