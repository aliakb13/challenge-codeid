package com.learning.final_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.final_project.model.mapper.MapperObj;
import com.learning.final_project.model.response.SupplierResponse;
import com.learning.final_project.repository.SupplierRepository;
import com.learning.final_project.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
  private final SupplierRepository repository;

  @Override
  public List<SupplierResponse> getAllData() {
    return repository.findAll().stream().map(MapperObj::mapToSupplierRes).toList();
  }

  @Override
  public SupplierResponse addData(SupplierResponse entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addData'");
  }

  @Override
  public SupplierResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public SupplierResponse updateData(SupplierResponse entity, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public Long deleteData(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
  }


}
