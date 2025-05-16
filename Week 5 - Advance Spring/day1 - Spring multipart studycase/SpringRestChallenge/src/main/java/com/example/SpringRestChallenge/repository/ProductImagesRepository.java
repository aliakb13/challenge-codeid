package com.example.SpringRestChallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringRestChallenge.model.entities.ProductImages;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, String> {
  // @Query("SELECT prodim FROM ProductImages prodim WHERE prodim.products.id: = productId")
  // List<ProductImages> findImagesByProduct(@Param("productId") Long id);
}
