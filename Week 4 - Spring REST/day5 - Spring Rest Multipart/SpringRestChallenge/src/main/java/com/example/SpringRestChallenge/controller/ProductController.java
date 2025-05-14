package com.example.SpringRestChallenge.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestChallenge.model.dto.request.ProductsDtoReq;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.service.ProductService;
import com.example.SpringRestChallenge.service.impl.ProductsServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController{
  private final ProductsServiceImpl productService;

  // private ProductService getService() {
  //   return productService;
  // }

  @GetMapping("")
  public ResponseEntity<?> getAllData() {
    return ResponseEntity.ok(new BaseResponse<List<ProductsDtoRes>>(1220, "successfully get all data!", productService.getAllData()));
  }
  
  @PostMapping("")
  public ResponseEntity<?> createData(@RequestBody @Valid ProductsDtoReq entity) {
     try {
      return ResponseEntity.status(201).body(new BaseResponse<ProductsDtoRes>(999, "successfully created", productService.addData(entity)));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(409).body(new BaseResponse<String>(1700,e.getMessage(), null));
    }
  }
}
