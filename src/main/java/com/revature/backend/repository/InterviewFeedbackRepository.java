package com.revature.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.backend.model.InterviewFeedback;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedback, Integer>{

}