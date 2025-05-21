package com.learning.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.final_project.model.response.SupplierResponse;
import com.learning.final_project.service.BaseCrudService;
import com.learning.final_project.service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierController extends BaseCrudController<SupplierResponse, Long, SupplierResponse>{
  private final SupplierService supplierService;

  @Override
  public BaseCrudService<SupplierResponse, Long, SupplierResponse> getService() {
    return supplierService;
  }

}
