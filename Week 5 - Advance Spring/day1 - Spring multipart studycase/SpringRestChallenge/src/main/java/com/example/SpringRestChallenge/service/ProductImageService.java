package com.example.SpringRestChallenge.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.SpringRestChallenge.model.dto.response.ProductImagesRes;
import com.example.SpringRestChallenge.model.entities.ProductImages;

public interface ProductImageService extends BaseService<ProductImagesRes, Long> {
  List<ProductImages> findImagesByProduct(@Param("productId") Long id);
}
