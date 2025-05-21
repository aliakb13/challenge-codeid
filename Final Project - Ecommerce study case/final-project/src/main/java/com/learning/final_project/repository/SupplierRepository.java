package com.learning.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.final_project.model.entities.Suppliers;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Long>{

  
}
