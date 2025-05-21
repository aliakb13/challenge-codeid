package com.learning.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.final_project.model.entities.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long>{
  
}
