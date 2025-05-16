package com.example.SpringRestChallenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringRestChallenge.model.dto.request.ProductImagesReq;
import com.example.SpringRestChallenge.model.dto.response.ProductImagesRes;
import com.example.SpringRestChallenge.model.entities.ProductImages;
import com.example.SpringRestChallenge.model.mapper.MapperObj;
import com.example.SpringRestChallenge.repository.ProductImagesRepository;
import com.example.SpringRestChallenge.repository.ProductsRepository;
import com.example.SpringRestChallenge.service.ProductImageService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl {
  private final ProductImagesRepository imagesRepository;

  public List<ProductImagesRes> getAllData() {
    return imagesRepository.findAll().stream().map(MapperObj::mapToProductImagesRes).collect(Collectors.toList());
  }

  // @Override
  // public ProductImagesRes addData(ProductImagesReq entity) {
    
  // }
}
