package com.example.SpringRestChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringRestChallenge.model.entities.Shippers;

@Repository
public interface ShippersRepository extends JpaRepository<Shippers, Long> {
  
}
