package com.revature.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.backend.model.AnalysisItem;
import com.revature.backend.model.Swot;
import com.revature.backend.service.SwotService;
import com.revature.backend.util.ClientMessage;
import static com.revature.backend.util.ClientMessageUtil.*;

//TODO fix imports for optimization

@RestController("swotController")
@RequestMapping("/swot")
public class SwotController {

	@Autowired
	private SwotService swotService;
	
	//create -swot
	@PostMapping(path="/create", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> createSwot(@RequestBody Swot swot) {
		ClientMessage body = swotService.createNewSwot(swot) ? SUCCESSFULLY_CREATED : CREATION_FAILED;
		return ResponseEntity.ok(body); //TODO this should be 201: CREATED
	}
	
	//get all -swot
	@GetMapping(path="/view", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Swot>> viewSwot(@RequestParam("associateId") int associateId) {
		List<Swot> swotList = swotService.retrieveAllSwotByAssociateID(associateId);
		return ResponseEntity.ok(swotList);
	}
	
	//create -item
	@PostMapping(path="/item/new", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> createItem(@RequestBody AnalysisItem analysisItem) {
		ClientMessage body = swotService.createNewItem(analysisItem) ? SUCCESSFULLY_CREATED : CREATION_FAILED;
		return ResponseEntity.ok(body); //TODO this should be 201: CREATED
	}
	
	//update -item
	@PutMapping(path="/item/update", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AnalysisItem> updateItem(@RequestBody AnalysisItem analysisItem) {
		AnalysisItem updatedItem = swotService.updateItem(analysisItem);
		if (updatedItem == null) {
			return ResponseEntity.badRequest().body(updatedItem);
		}
		else {
			return ResponseEntity.ok(updatedItem); //TODO: this causes problems, needs to be fixed.
		}
	}
	
	//delete -item
	@DeleteMapping(path="/item/delete", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClientMessage> createSwot(@RequestBody AnalysisItem analysisItem) {
		ClientMessage body = swotService.deleteItem(analysisItem) ? SUCCESSFULLY_DELETED : DELETION_FAILED;
		return ResponseEntity.ok(body);
	}
}
