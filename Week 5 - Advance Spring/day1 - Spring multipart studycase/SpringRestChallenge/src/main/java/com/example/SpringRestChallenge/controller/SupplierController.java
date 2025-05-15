package com.example.SpringRestChallenge.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringRestChallenge.model.dto.SupplierDto;
import com.example.SpringRestChallenge.service.BaseService;
import com.example.SpringRestChallenge.service.SupplierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierController extends BaseController<SupplierDto, Long> {
  private final SupplierService service;

  @Override
  public BaseService<SupplierDto, Long> getService() {
    return service;
  }
}
