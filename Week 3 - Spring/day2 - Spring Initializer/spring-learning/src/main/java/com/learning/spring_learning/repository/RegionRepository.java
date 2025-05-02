package com.learning.spring_learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring_learning.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

  
}
