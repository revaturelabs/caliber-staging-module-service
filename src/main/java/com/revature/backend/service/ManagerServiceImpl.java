package com.revature.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.Manager;
import com.revature.backend.repository.ManagerRepository;

@Service("selectAllManagers")
public class ManagerServiceImpl implements ManagerService {
	
	private static Logger log = Logger.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	ManagerRepository managerRepo;

	/* 
	 * This class will return a list of Manager objects as well as Manager - Associate mappings.
	 * 
	 * getAllManagers() has been completed. Next I will implement a method that uses a map to return Manager and Associate objects.
	 * 
	 */

	public List<Manager> getAllManagers() {
		List<Manager> managerList = new ArrayList<>();
		
		try {
			// Dao method here
			managerRepo.findAllManagers();
		} catch(Exception e) {
			
			if(managerList.size() != 0) {
				log.info("Attempting to retrieve Manager objects.");
				return managerList;
				
			} 
			log.warn("Unable to retrieve managers - Service Layer", e);
				return null;
		}
		return managerList;
	}
	
	
// Will possibly use for HashMap.
	
//	private List<Associate> getAssociates() {
//		List<Associate> associate = new ArrayList<>();
//		List<Associate> associates =  associate.stream().collect(Collectors.toList());
//		
//		if(associates == null) {
//			log.warn("Unable to compile associate list.");
//		} else {
//			log.info("Associate list is successfully compiled.");
//		}
//	
//		return associates;
//	}
	
	

}
