package com.revature.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.revature.backend.model.Manager;
import com.revature.backend.service.ManagerService;
import com.revature.backend.util.StagingListener;


/**
 * This class acts as a starter-motor for the ManagerLoadBalancing system. Once Spring completely finishes loading, it'll start the {@link StagingListener}.
 *  
 * Any other methods that should run on startup should also be called here to prevent conflict with Spring's bootup.
 * @author Ben Johnston
 *
 */
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	StagingListener sListener;
	@Autowired
	ManagerService mServ;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// This block is used for testing until we have an official database set up. Allows time to add info to database (like managers) before the system checks for batches
		//-------------
		List<Manager> mList = new ArrayList<>();
		Manager m = new Manager("Testemail@email.email", "test", "user");
		Manager m1 = new Manager("Testemail2@email.email", "test2", "user2");
		Manager m2 = new Manager("Testemail3@email.email", "test3", "user3");
		mList.add(m);
		mList.add(m1);
		mList.add(m2);
		mServ.saveAll(mList);
		//-------------
		
		//Starts the periodic checking for new batches. Will run immediately on server start up, then weekly on the specified UpdateDay until the server is restarted.
		sListener.startListening();
	}	
	
}
