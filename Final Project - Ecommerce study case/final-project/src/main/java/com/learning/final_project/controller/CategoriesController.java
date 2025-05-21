package com.learning.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.final_project.model.response.CategoryResponse;
import com.learning.final_project.service.BaseCrudService;
import com.learning.final_project.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController extends BaseCrudController<CategoryResponse, Long, CategoryResponse> {

  private final CategoryService service;
  
  @Override
  public BaseCrudService<CategoryResponse, Long, CategoryResponse> getService() {
    return service;
  }
  
}
