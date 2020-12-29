package com.revature.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.backend.model.Associate;

//@Repository
@Transactional
public interface AssociateRepository  extends JpaRepository<Associate, Long>{

    @Query(value = "select * from associate where manager_id =?1", nativeQuery = true)
    public void saveAll(List<Associate> aList);
}
