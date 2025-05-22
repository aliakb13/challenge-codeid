package com.learning.final_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.final_project.model.entities.carts.Carts;

@Repository
public interface CartRepository extends JpaRepository<Carts, String>{
  @Query("SELECT c FROM Carts c WHERE c.user.id = ?1")
  Optional<Carts> findCartByUserId(Long userId);
}
