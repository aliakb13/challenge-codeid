package com.example.SpringRestChallenge.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SpringRestChallenge.model.dto.request.ProductsDtoReq;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.model.entities.Products;
import com.example.SpringRestChallenge.model.mapper.MapperObj;
import com.example.SpringRestChallenge.repository.CategoriesRepository;
import com.example.SpringRestChallenge.repository.ProductsRepository;
import com.example.SpringRestChallenge.repository.SupplierRepository;
import com.example.SpringRestChallenge.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl{

  private final ProductsRepository productsRepository;
  private final SupplierRepository supplierRepository;
  private final CategoriesRepository categoriesRepository;
  
  public List<ProductsDtoRes> getAllData() {
    return productsRepository.findAll().stream().map(MapperObj::mapToProductsDto).collect(Collectors.toList());
  }

  public ProductsDtoRes addData(ProductsDtoReq entity) {
    var supplier = supplierRepository.findById(entity.getSupplierId()).orElseThrow(() -> new EntityNotFoundException("supplier with id " + entity.getSupplierId() + " was not found!"));
    var category = categoriesRepository.findById(entity.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("category with id " + entity.getCategoryId() + " was not found!"));

    return MapperObj.mapToProductsDto(productsRepository.save(Products.builder()
                                                              .name(entity.getProductName())
                                                              .supplier(supplier)
                                                              .category(category)
                                                              .quantity("contain something")
                                                              .unitPrice(entity.getUnitPrice())
                                                              .unitStock(50L)
                                                              .unitOrder(100L)
                                                              .reorderLvl(50L)
                                                              .discontinued(new Random().nextInt(0,1))
                                                              .photo(null)
                                                              .build()));
  }

  public ProductsDtoRes findDataById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findDataById'");
  }

  public ProductsDtoRes updateData(ProductsDtoRes entity, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  public Long delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
  
}
