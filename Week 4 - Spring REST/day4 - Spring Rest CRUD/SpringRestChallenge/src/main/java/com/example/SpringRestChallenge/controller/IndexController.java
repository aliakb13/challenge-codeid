package com.example.SpringRestChallenge.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class IndexController {

  @GetMapping("/hello-world")
  public ResponseEntity<String> getMethodName() {
      return ResponseEntity.ok("Server berjalan!!");
  }
  
}
