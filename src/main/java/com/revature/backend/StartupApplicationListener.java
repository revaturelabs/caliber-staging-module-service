package com.revature.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.revature.backend.util.StagingListener;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent>{

	//Any logic that should run after SpringBoot finishes loading should be done in this class.
	
	@Autowired
	StagingListener sListener;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		sListener.startListening();
	}

	
	
	
}
