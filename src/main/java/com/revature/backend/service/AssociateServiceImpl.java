package com.revature.backend.service;

import java.util.List;
import java.util.Optional;

import com.revature.backend.model.Associate;
import com.revature.backend.repository.AssociateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("associateService")
public class AssociateServiceImpl implements AssociateService {

    @Autowired
    AssociateRepository associateRepo;

    @Override
    public List<Associate> getAllAssociates() {
        return null;
    }

    @Override
    public List<Associate> saveAssociates(List<Associate> aList) {
        // call the appropriate Repo method to save (aka insert) associates into DB
        List<Associate> list = associateRepo.saveAll(aList);
        return list;
    }
    
    public Associate getAssociateById(int id) {
    	// TODO call the appropriate Repo method to update an associate into DB
    	return associateRepo.findById(id).get();
    }
    
    
    public void updateAssociate(Associate associate) {
    	// TODO call the appropriate Repo method to update an associate into DB
    	System.out.println("hi");
    	associateRepo.save(associate);
    }
    
}
