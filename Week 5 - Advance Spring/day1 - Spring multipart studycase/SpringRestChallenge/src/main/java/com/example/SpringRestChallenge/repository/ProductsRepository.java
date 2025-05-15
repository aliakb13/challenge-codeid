package com.example.SpringRestChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringRestChallenge.model.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
  
}
