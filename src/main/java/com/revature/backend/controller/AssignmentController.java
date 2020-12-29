package com.revature.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.revature.backend.model.Associate;
import com.revature.backend.model.AssociateStatus;
import com.revature.backend.model.Batch;
import com.revature.backend.model.api.ApiAssociateAssignment;
import com.revature.backend.model.api.ApiAssociateTemplate;
import com.revature.backend.model.api.ApiBatchTemplate;
import com.revature.backend.service.ManagerBalancerImpl;
import com.revature.backend.service.ManagerServiceImpl;
import com.revature.backend.util.BatchRetriever;
import com.revature.backend.util.BatchRetrieverImpl;
import com.revature.backend.util.StagingListenerImpl;

@Controller
public class AssignmentController {

	private static BatchRetriever batchRetriever = new BatchRetrieverImpl();
	private static Logger log = Logger.getLogger(AssignmentController.class);
	@Autowired
	ManagerBalancerImpl balancer;
	@Autowired
	ManagerServiceImpl managerService;

	/**
	 * This method runs after the {@link StagingListener} detects new batches.
	 * Converts Associates from the raw API object into database ready objects. Sends new
	 * Associate list to
	 * 
	 * @return
	 */
	public void addNewBatches() {
		List<Batch> convertedBatches = new ArrayList<>();
		List<Associate> convertedAssociates = new ArrayList<>();
		//Retrieve batches from BatchRetriever
		List<ApiBatchTemplate> batches = batchRetriever.retrieveNewlyStagingBatches();
		for (ApiBatchTemplate batch : batches) 
		{
			// Convert batch to Batch Object & add to a list
			Batch b = convertToBatch(batch);
			convertedBatches.add(b);

			// Convert each Associate to an Associate Object, assign them to the batch, give
			// them a status, & add them to a list
			for (ApiAssociateAssignment assignment : batch.getAssociateAssignments())
			{
				Associate a = convertToAssociate(assignment.getAssociate());
				a.setBatch(b);
				a.setStatus(AssociateStatus.STAGING);
				convertedAssociates.add(a);

			}

		}
		
		if(convertedAssociates.size() == 0 || convertedBatches.size() ==0)
		{
			//If either size is 0, then the data retrieval failed and should be attempted again.
			log.error("No batches with associates found");
			
		}
		else 
		{
			//Balance out associates to each manager, by batch size.
			//balancer.balanceNewBatches(/*coming soon*/, convertedAssociates);
						
		}

	}

	// ----------------
	// Helper Methods
	// ----------------

	/**
	 * Converts an {@link ApiBatchTemplate} to a {@link Batch}
	 * 
	 * @param batch
	 * @return {@link Batch}
	 */
	public Batch convertToBatch(ApiBatchTemplate batch) {
		return new Batch(batch.getBatchId(), batch.getName(), batch.getSkill(), batch.getLocation());
	}

	/**
	 * Converts an {@link ApiAssociateTemplate} to an {@link Associate}
	 * 
	 * @param associate
	 * @return {@link Associate}
	 */
	public Associate convertToAssociate(ApiAssociateTemplate associate) {
		return new Associate(associate.getSalesforceId(), associate.getEmail(), associate.getFirstName(),
				associate.getLastName(), null, null, null);
	}

}
