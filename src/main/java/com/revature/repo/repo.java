package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Associate;

@Transactional
public interface repo extends JpaRepository<Associate, Long>{

	@Query(value = "select * from associates where manager_id =?1", nativeQuery = true)
	List<Associate> findAssociatesByManager_Id(int id);
	
	
	
}