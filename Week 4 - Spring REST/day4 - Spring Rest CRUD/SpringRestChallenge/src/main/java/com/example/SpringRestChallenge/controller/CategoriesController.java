package com.example.SpringRestChallenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestChallenge.model.dto.CategoriesDto;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.service.CategoriesService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

  private final CategoriesService service;

  @GetMapping("")
  public ResponseEntity<List<CategoriesDto>> getCategories() {
      return ResponseEntity.ok(service.getAllData());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
      try {
        return ResponseEntity.ok(new BaseResponse<CategoriesDto>(1000, "Success get data!", service.findDataById(id)));
      } catch(EntityNotFoundException e) {
        return ResponseEntity.status(404)
          .body(new BaseResponse<CategoriesDto>(1220,e.getMessage(),null));
      }
  }

  @PostMapping("")
  public ResponseEntity<?> createCategory(@RequestBody @Valid CategoriesDto entity) {
      try {
        // return ResponseEntity.status(201).body(new BaseResponse<String>(1330, "Successfully Created", 
        // "Category with id " + entity.getCategoryId() + " and name " + entity.getCategoryName() + " is created!"));

        return ResponseEntity.status(201).body(new BaseResponse<CategoriesDto>(1220, "successfully created", service.addData(entity)));
      } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(409).body(new BaseResponse<String>(1225,e.getMessage(), null));
      }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editCategory(@PathVariable Long id, @RequestBody @Valid CategoriesDto entity) {
      try {
        return ResponseEntity.status(200).body(new BaseResponse<CategoriesDto>(
        1100, "success edit data!", service.updateData(entity, id))
      );
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1220, e.getMessage(), null));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
    try {
      return ResponseEntity.status(200).body(new BaseResponse<Long>(
        1100, "success deleting data with id " + service.delete(id) + "!", null)
      );
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1220, e.getMessage(), null));
    }
  }
  
  
  
}
