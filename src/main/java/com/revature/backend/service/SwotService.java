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
	
	/*
	 * Creates a new SWOT with initial AnalysisItems.
	 * 
	 * The Swot object is the parent object for each
	 * individual AnalysisItem (Swot > AnalysisItem).
	 * 
	 * Each AnalysisItem has a foreign key reference to
	 * it's owning SWOT.
	 * 
	 * The JSON array of AnalysisItems needs to be stored
	 * in a holder list where it will have the foreign key
	 * set to the parent SWOT's id.
	 * 
	 * After, the List of AnalysisItems is
	 * properly assigned to it's parent
	 * Swot object.
	 * 
	 * Returns true if successful, false otherwise.
	 */
	public boolean createNewSwot(Swot swot) {
		Swot parent = new Swot(swot.getAssociate(), swot.getManager(), swot.getCreatedOn(), swot.getLastModified(), swot.getDescription()); // jackson creates swot object
		List<AnalysisItem> items = swot.getAnalysisItems(); // we fetch all items from postman input
		for (AnalysisItem item : items) { // we add all items to parent object created by jackson
			item.setSwot(parent);		
		}
		parent.setAnalysisItems(items); // we add parent object to all items(this time items have parent object inside)
		return swotRepository.save(parent) != null; // we create parent object in db
	}

	/*
	 * Retrieves all SWOTs by the AssociateId.
	 * Takes in the Associate's id (as an int)
	 * as a parameter.
	 * Returns a List of Swots for that Associate.
	 */
	public List<Swot> retrieveAllSwotByAssociateId(int associateId) {
		return swotRepository.findAllByAssociateId(associateId);
	}
	
	/*
	 * Creates a new AnalysisItem for a SWOT.
	 * Accepts the AnalysisItem as a parameter.
	 * Returns true if successful, false otherwise.
	 */
	public boolean createNewItem(AnalysisItem analysisItem) {
		return analysisItemRepository.save(analysisItem) != null;
	}

	/*
	 * Updates an AnalysisItem.
	 * Takes the AnalysisItem object that needs to 
	 * be updated with the changed fields.
	 * 
	 * Prior to calling the repo, set the respective SWOT's
	 * lastModified field to System.currentTimeMillis() and
	 * then save the object to the database to update.
	 * 
	 * Returns the updated item if successful.
	 */
	public AnalysisItem updateItem(AnalysisItem analysisItem) {
		Swot updateSwot = swotRepository.findById(analysisItem.getSwot().getId()).get();
		updateSwot.setLastModifiedNow();	
		swotRepository.save(updateSwot);
		return analysisItemRepository.save(analysisItem);
	}
	
	/*
	 * Deletes an AnalysisItem from a SWOT by
	 * its id.
	 * Only takes in the Id as an integer as a
	 * parameter.
	 * Should return true if successful, false
	 * otherwise. 
	 */
	public boolean deleteItem(int analysisItemId) {
		analysisItemRepository.deleteById(analysisItemId);
		return true; //TODO: this will always return true, fix the condition.
	}
	
	/*
	 * Method to retrieve all SWOTs found in the
	 * database.
	 * Currently only used for testing purposes.
	 */
	public List<Swot> retrieveAllSwot() {
		return swotRepository.findAll();
	}
	
}
