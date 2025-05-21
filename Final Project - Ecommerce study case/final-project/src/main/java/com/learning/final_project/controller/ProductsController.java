package com.learning.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.final_project.model.request.ProductRequest;
import com.learning.final_project.model.response.ProductResponse;
import com.learning.final_project.service.BaseCrudService;
import com.learning.final_project.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController extends BaseCrudController<ProductResponse, Long, ProductRequest>{

  private final ProductService service;
  
  @Override
  public BaseCrudService<ProductResponse, Long, ProductRequest> getService() {
    return service;
  }

  @GetMapping("/gallery")
  public ResponseEntity<?> sortProductsWithPageable(Pageable pageable) {
      return ResponseEntity.ok(
        service.sortWithoutKeyword(pageable)
      );
  }

  @GetMapping("/search")
  public ResponseEntity<?> searchProductsWithPageable(@RequestParam String keyword, Pageable pageable) {
      return ResponseEntity.ok(
        service.sortWithKeyword(keyword, pageable)
      );
  }
  
}
