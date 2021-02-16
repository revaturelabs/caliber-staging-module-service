package com.revature.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.BackendRepo;
import com.revature.backend.repository.ManagerRepository;

@Service("selectAllManagers")
public class ManagerServiceImpl implements ManagerService {
	
	private static Logger log = Logger.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	ManagerRepository managerRepo;
	
	@Autowired
	BackendRepo backendRepo;

	/**
	 * This class will take a list of managers, save them in the database,
	 * then return the same list back with changes made by the
	 * JpaRepository during save().
	 * @param mList is a list of managers
	 * @return result is a modified mList
	 */
	@Override
	public List<Manager> saveAll(List<Manager> mList) {
		List<Manager> result = new ArrayList<>();

		for(Manager m : mList)
		{
			result.add(managerRepo.save(m));
		}
		 return result;
		
	}

	/**
	 * @return List of all Managers from the database.
	 */
	public List<Manager> getAllManagers() {
		List<Manager> managerList = new ArrayList<>();
		
		try {
			log.info("finding managers");
			managerList = managerRepo.findAllManagers();
		} catch(Exception e) {
			
			if(managerList.size() != 0) {
				log.info("Attempting to retrieve Manager objects.");
				return managerList;
				
			} 
			log.warn("Unable to retrieve managers - Service Layer", e);
				return null;
		}
		log.info("Size of manager list is " + managerList.size());
		return managerList;
	}
	
	public Manager getManagerById(int id) {
		return managerRepo.findById(id);
	}
	
	/* It would be better if getAllManagersAndAssociates() used
	 * countAssociatesByManager in the AssociateRepository rather creating
	 * entire lists of Associates, counting them, then throwing away the list.
	 */
	/**
	 * This method returns a map of managers matched with the number of
	 * associates assigned to each.
	 * @return Map of managers and a count of their associates
	 */
	@Override
	public Map<Manager, Integer> getAllManagersAndAssociates() {
		
		List<Manager> managers;
		managers = getAllManagers();
		Map <Manager, Integer> map = new HashMap<Manager, Integer>();
		
		for(Manager manager : managers) {
			
			List<Associate> associates 
				= backendRepo.findAssociatesByManagerId(manager.getId());
			int associateSize = associates.size();
			
			map.put(manager, associateSize);
		}
		return map;
	}





	
	// method to add in managers to the database
	// Session storage can possibly add managers
	
	

}
