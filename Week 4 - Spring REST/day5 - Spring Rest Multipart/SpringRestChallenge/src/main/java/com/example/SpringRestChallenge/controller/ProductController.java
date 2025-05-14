package com.example.SpringRestChallenge.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestChallenge.model.dto.request.ProductsDtoReq;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.service.impl.ProductsServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController{
  private final ProductsServiceImpl productService;

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

  @GetMapping("/{id}")
  public ResponseEntity<?> getDataById(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(new BaseResponse<ProductsDtoRes>(1220, "Success get data!", productService.findDataById(id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404)
        .body(new BaseResponse<String>(1500,e.getMessage(),null));
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editData(@PathVariable Long id, @RequestBody @Valid ProductsDtoReq entity) {
    try {
      return ResponseEntity.ok(new BaseResponse<ProductsDtoRes>(
      1100, "success edit data!", productService.updateData(entity, id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteData(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(new BaseResponse<Long>(
        1220, "success deleting data with id " + productService.delete(id) + "!", null));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }
}
