package com.revature.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.AnalysisItem;
import com.revature.backend.model.Swot;
import com.revature.backend.repository.AnalysisItemRepository;
import com.revature.backend.repository.SwotRepository;

@Service("swotService")
public class SwotService {

	@Autowired
	SwotRepository swotRepository;
	
	@Autowired
	AnalysisItemRepository analysisItemRepository;
	
	//create -swot
	public boolean createNewSwot(Swot swot) {
		return swotRepository.save(swot) != null;
	}

	//get all by associate id -swot
	public List<Swot> retrieveAllSwotByAssociateID(int associateId) {
		return swotRepository.findAllByAssociateID(associateId);
	}
	
	//create -item
	public boolean createNewItem(AnalysisItem analysisItem) {
		return analysisItemRepository.save(analysisItem) != null;
	}

	//update -item
	public AnalysisItem updateItem(AnalysisItem analysisItem) {
		return analysisItemRepository.save(analysisItem);
	}

	//delete -item
	public boolean deleteItem(AnalysisItem analysisItem) {
		analysisItemRepository.delete(analysisItem);
		return true; //TODO: this will always return true, fix the condition.
	}
	
}
