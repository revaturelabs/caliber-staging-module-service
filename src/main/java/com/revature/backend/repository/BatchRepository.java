package com.revature.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.backend.model.Batch;

@Repository
<<<<<<< HEAD
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	public Batch findById(int id);
=======
public interface BatchRepository extends JpaRepository<Batch, Integer> {
>>>>>>> c375196aafda135eefaa4552dc6c892d4c8f3182

}
