package com.learning.final_project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.learning.final_project.model.request.ProductRequest;
import com.learning.final_project.model.response.ProductResponse;

public interface ProductService extends BaseCrudService<ProductResponse, Long, ProductRequest>{

  Page<ProductResponse> sortWithoutKeyword(Pageable pageable);
  Page<ProductResponse> sortWithKeyword(String keyword, Pageable pageable);
}