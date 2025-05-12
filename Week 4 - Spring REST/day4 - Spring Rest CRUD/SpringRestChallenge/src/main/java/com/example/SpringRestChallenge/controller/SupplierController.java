package com.example.SpringRestChallenge.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringRestChallenge.model.dto.SupplierDto;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.service.SupplierService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierController extends BaseController<SupplierDto, Long> {
  private final SupplierService service;

  @Override
  public ResponseEntity<?> getAllData() {
    return ResponseEntity.ok(new BaseResponse<List<SupplierDto>>(1220, "successfully get all data!", service.getAllData()));
  }

  @Override
  public ResponseEntity<?> getDataById(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(new BaseResponse<SupplierDto>(1000, "Success get data!", service.findDataById(id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404)
        .body(new BaseResponse<String>(1220,e.getMessage(),null));
    }
  }

  @Override
  public ResponseEntity<?> createData(@RequestBody @Valid SupplierDto entity) {
    try {
      return ResponseEntity.status(201).body(new BaseResponse<SupplierDto>(1220, "successfully created", service.addData(entity)));
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.status(409).body(new BaseResponse<String>(1225,e.getMessage(), null));
    }
  }

  @Override
  public ResponseEntity<?> editData(@PathVariable Long id, @RequestBody @Valid SupplierDto entity) {
    try {
      return ResponseEntity.status(200).body(new BaseResponse<SupplierDto>(
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
