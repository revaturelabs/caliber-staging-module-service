package com.revature.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.backend.model.Swot;

@Repository
public interface SwotRepository extends JpaRepository<Swot, Integer> {

	//DBG if this crashes use associate_id instead of associate TODO: remove this
	@Query(value = "select * from swot_analysis where associate =?1", nativeQuery = true)
	List<Swot> findAllByAssociateID(int associateId);
}