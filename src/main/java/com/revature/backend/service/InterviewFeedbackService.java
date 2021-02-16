package com.revature.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.backend.model.Associate;
import com.revature.backend.model.InterviewFeedback;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.InterviewFeedbackRepository;

@Service("interviewFeedbackService")
public class InterviewFeedbackService {
	private final InterviewFeedbackRepository ifRepo;

  public InterviewFeedbackService(InterviewFeedbackRepository ifRepo) {
    this.ifRepo = ifRepo;
  }

	public List<InterviewFeedback> retrieveAllFeedback() {
		return ifRepo.findAll();
	}

	public InterviewFeedback retrieveFeedbackById(int id) {
		return ifRepo.findById(id);
	}

	public List<InterviewFeedback> retrieveFeedbackByAssociate(Associate associate) {
		return ifRepo.findByAssociate(associate);
	}

	public List<InterviewFeedback> retrieveFeedbackByManager(Manager manager) {
		return ifRepo.findByManager(manager);
	}

	public void insertFeedback(InterviewFeedback feedback) {
		ifRepo.save(feedback);
	}

	public void updateFeedback(InterviewFeedback feedback) {
		ifRepo.save(feedback);
	}

	public void deleteFeedback(InterviewFeedback feedback) {
		ifRepo.delete(feedback);
	}
}
