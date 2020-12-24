package com.revature.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.backend.model.AnalysisItem;

public interface AnalysisItemRepository extends JpaRepository<AnalysisItem, Integer>{

}
