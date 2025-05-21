package com.learning.final_project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.final_project.model.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{

  @Query(value = "SELECT p FROM Products p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
  Page<Products> findByNameContainingIgnoreCase(@Param("keyword") String keyword, Pageable pageable);
}
