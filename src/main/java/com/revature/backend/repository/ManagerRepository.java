package com.revature.backend.repository;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.backend.model.Manager;

@Transactional
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	@Query(value = "SELECT * FROM manager", nativeQuery = true)
	List<Manager> findAllManagers();

	Manager findById(int id);

    Manager findByEmail(String email);
}
