package com.learning.final_project.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learning.final_project.model.entities.Products;
import com.learning.final_project.model.mapper.MapperObj;
import com.learning.final_project.model.request.ProductRequest;
import com.learning.final_project.model.response.ProductResponse;
import com.learning.final_project.repository.CategoryRepository;
import com.learning.final_project.repository.ProductRepository;
import com.learning.final_project.repository.SupplierRepository;
import com.learning.final_project.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final SupplierRepository supplierRepository;
  
  @Override
  public List<ProductResponse> getAllData() {
    return productRepository.findAll().stream().map(MapperObj::mapToProductResponse).toList();
  }

  @Override
  public ProductResponse addData(ProductRequest entity) {
    var supplier = supplierRepository.findById(entity.getSupplierId()).orElseThrow(() -> new EntityNotFoundException("supplier with id " + entity.getSupplierId() + " was not found!"));
    var category = categoryRepository.findById(entity.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("category with id " + entity.getCategoryId() + " was not found!"));

    var product = Products.builder()
                  .name(entity.getProductName())
                  .supplier(supplier)
                  .category(category)
                  .price(entity.getUnitPrice())
                  .quantity("contain something")
                  .stock(100)
                  .unitOrder(new Random().nextInt(1,201))
                  .reoderLevel(new Random().nextInt(1,101))
                  .discontinued(new Random().nextInt(0,2))
                  .build();

    return MapperObj.mapToProductResponse(productRepository.save(product));
  }

  @Override
  public ProductResponse findById(Long id) {
    return productRepository.findById(id).map(MapperObj::mapToProductResponse).orElseThrow(() -> new EntityNotFoundException("product with id " + id + " was not found!"));
  }

  @Override
  public ProductResponse updateData(ProductRequest entity, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public Long deleteData(Long id) {
    var product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product with id " + id + " was not found!"));

    productRepository.delete(product);
    return id;
  }

  @Override
  public Page<ProductResponse> sortWithoutKeyword(Pageable pageable) {
    return productRepository.findAll(pageable).map(MapperObj::mapToProductResponse);
  }

  @Override
  public Page<ProductResponse> sortWithKeyword(String keyword, Pageable pageable) {
    return productRepository.findByNameContainingIgnoreCase(keyword, pageable).map(MapperObj::mapToProductResponse);
  }
  
}
