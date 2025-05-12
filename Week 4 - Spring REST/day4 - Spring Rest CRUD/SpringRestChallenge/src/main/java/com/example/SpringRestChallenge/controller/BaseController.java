package com.example.SpringRestChallenge.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;

@MappedSuperclass
public abstract class BaseController<T, ID> {

  @GetMapping("")
  public abstract ResponseEntity<?> getAllData();

  @GetMapping("/{id}")
  public abstract ResponseEntity<?> getDataById(@PathVariable ID id);

  @PostMapping("")
  public abstract ResponseEntity<?> createData(@RequestBody @Valid T entity);

  @PutMapping("/{id}")
  public abstract ResponseEntity<?> editData(@PathVariable ID id, @RequestBody @Valid T entity);

  @DeleteMapping("/{id}")
  public abstract ResponseEntity<?> deleteData(@PathVariable ID id);
}
