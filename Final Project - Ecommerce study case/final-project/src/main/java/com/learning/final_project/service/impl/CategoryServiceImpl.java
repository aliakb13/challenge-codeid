package com.learning.final_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.final_project.model.mapper.MapperObj;
import com.learning.final_project.model.response.CategoryResponse;
import com.learning.final_project.repository.CategoryRepository;
import com.learning.final_project.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  
  private final CategoryRepository repository;

  @Override
  public List<CategoryResponse> getAllData() {
    return repository.findAll().stream().map(MapperObj::mapToCategoryRes).toList();
  }

  @Override
  public CategoryResponse addData(CategoryResponse entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addData'");
  }

  @Override
  public CategoryResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public CategoryResponse updateData(CategoryResponse entity, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public Long deleteData(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
  }
  
}
