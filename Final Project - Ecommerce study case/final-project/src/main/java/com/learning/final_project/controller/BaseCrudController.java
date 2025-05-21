package com.learning.final_project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.final_project.model.response.handling.BaseResponse;
import com.learning.final_project.service.BaseCrudService;

import jakarta.validation.Valid;

public abstract class BaseCrudController<ResObj, ID, ReqObj> {

  public abstract BaseCrudService<ResObj, ID, ReqObj> getService();

  @GetMapping("")
  public ResponseEntity<?> getAllData() {
    // BaseResponse<List<ResObj>> response = BaseResponse
    return ResponseEntity.ok(
      BaseResponse.<List<ResObj>>builder()
        .statusCode(HttpStatus.OK)
        .message("Success get all data!")
        .data(getService().getAllData())
        .build()
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findDataById(@PathVariable ID id) {
    return ResponseEntity.ok(
      BaseResponse.<ResObj>builder()
        .statusCode(HttpStatus.OK)
        .message("Success get data!")
        .data(getService().findById(id))
        .build()
    );
  }

  @PostMapping("")
  public ResponseEntity<?> createData(@RequestBody @Valid ReqObj req) {
    return ResponseEntity.ok(
      BaseResponse.<ResObj>builder()
        .statusCode(HttpStatus.CREATED)
        .message("Success create data!")
        .data(getService().addData(req))
        .build()
    );
  }

  // @PutMapping("/{id}")
  // public ResponseEntity<?> updateData(@RequestBody @Valid ReqObj req, @PathVariable ID id) {

  // }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteDataById(@PathVariable ID id) {
    return ResponseEntity.ok(
      BaseResponse.<String>builder()
        .statusCode(HttpStatus.OK)
        .message("Data was successfully deleted!")
        .data("Data with id = " + getService().deleteData(id) + " deleted!")
        .build()
    );
  }
}
