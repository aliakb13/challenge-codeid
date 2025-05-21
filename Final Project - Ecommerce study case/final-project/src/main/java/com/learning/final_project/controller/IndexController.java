package com.learning.final_project.controller;
import org.springframework.web.bind.annotation.RestController;

import com.learning.final_project.model.response.handling.BaseResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class IndexController {
  @GetMapping("/hello-world")
  public ResponseEntity<?> getMethodName() {
      return ResponseEntity.ok(
        BaseResponse.builder().statusCode(HttpStatus.OK).message("Server Running!!").data(null).build()
      );
  }
  
}
