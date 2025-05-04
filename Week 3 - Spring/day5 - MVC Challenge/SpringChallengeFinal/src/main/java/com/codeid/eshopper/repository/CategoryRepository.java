package com.codeid.eshopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopper.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
