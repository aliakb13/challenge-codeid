package com.learning.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.final_project.model.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
  
}
