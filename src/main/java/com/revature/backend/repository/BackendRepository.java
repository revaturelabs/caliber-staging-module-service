package com.revature.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.backend.model.Associate;

@Transactional
@Repository
public interface BackendRepository extends JpaRepository<Associate, Long> {

  @Query(value = "SELECT * FROM associate WHERE manager_id = ?1", nativeQuery = true)
  List<Associate> findAssociatesByManagerId(int id);

}
