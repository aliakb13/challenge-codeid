package com.codeid.eshopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopper.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
