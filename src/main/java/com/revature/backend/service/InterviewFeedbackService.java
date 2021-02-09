package com.revature.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.backend.repository.InterviewFeedbackRepository;

@Service("interviewFeedbackService")
public class InterviewFeedbackService {

	@Autowired
	InterviewFeedbackRepository ifRepo;
	
}
