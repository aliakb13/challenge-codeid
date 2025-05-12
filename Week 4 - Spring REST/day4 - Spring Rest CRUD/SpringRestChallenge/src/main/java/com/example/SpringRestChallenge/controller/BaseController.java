package com.example.SpringRestChallenge.controller;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.service.BaseService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;

@MappedSuperclass
public abstract class BaseController<T, ID> {

  public abstract BaseService<T, ID> getService();

  @GetMapping("")
  public ResponseEntity<?> getAllData() {
    return ResponseEntity.ok(new BaseResponse<List<T>>(1220, "successfully get all data!", getService().getAllData()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getDataById(@PathVariable ID id) {
    try {
      return ResponseEntity.ok(new BaseResponse<T>(1220, "Success get data!", getService().findDataById(id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404)
        .body(new BaseResponse<String>(1500,e.getMessage(),null));
    }
  }

  @PostMapping("")
  public ResponseEntity<?> createData(@RequestBody @Valid T entity) {
     try {
      return ResponseEntity.status(201).body(new BaseResponse<T>(999, "successfully created", getService().addData(entity)));
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.status(409).body(new BaseResponse<String>(1700,e.getMessage(), null));
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editData(@PathVariable ID id, @RequestBody @Valid T entity) {
    try {
      return ResponseEntity.ok(new BaseResponse<T>(
      1100, "success edit data!", getService().updateData(entity, id)));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteData(@PathVariable ID id) {
    try {
      return ResponseEntity.ok(new BaseResponse<Long>(
        1220, "success deleting data with id " + getService().delete(id) + "!", null));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }
}
