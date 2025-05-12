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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController extends BaseController<CategoriesDto, Long> {

  private final CategoriesService service;

  @Override
  public ResponseEntity<?> getAllData() {
    return ResponseEntity.status(201).body(new BaseResponse<List<CategoriesDto>>(1220, "successfully get all data!", service.getAllData()));
  }

  @Override
  public ResponseEntity<?> getDataById(@PathVariable Long id) {
   try {
      return ResponseEntity.ok(new BaseResponse<CategoriesDto>(1000, "Success get data!", service.findDataById(id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404)
        .body(new BaseResponse<CategoriesDto>(1220,e.getMessage(),null));
    }
  }

  @Override
  public ResponseEntity<?> createData(@RequestBody @Valid CategoriesDto entity) {
    try {
      // return ResponseEntity.status(201).body(new BaseResponse<String>(1330, "Successfully Created", 
      // "Category with id " + entity.getCategoryId() + " and name " + entity.getCategoryName() + " is created!"));

      return ResponseEntity.status(201).body(new BaseResponse<CategoriesDto>(1220, "successfully created", service.addData(entity)));
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.status(409).body(new BaseResponse<String>(1225,e.getMessage(), null));
    }
  }

  @Override
  public ResponseEntity<?> editData(@PathVariable Long id, @RequestBody @Valid CategoriesDto entity) {
    try {
      return ResponseEntity.status(200).body(new BaseResponse<CategoriesDto>(
      1100, "success edit data!", service.updateData(entity, id)));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1220, e.getMessage(), null));
    }
  }

  @Override
  public ResponseEntity<?> deleteData(@PathVariable Long id) {
    try {
      return ResponseEntity.status(200).body(new BaseResponse<Long>(
        1100, "success deleting data with id " + service.delete(id) + "!", null));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1220, e.getMessage(), null));
    }
  }
}
