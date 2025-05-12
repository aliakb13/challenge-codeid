package com.example.SpringRestChallenge.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringRestChallenge.model.dto.ShippersDto;
import com.example.SpringRestChallenge.service.BaseService;
import com.example.SpringRestChallenge.service.ShippersService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shippers")
public class ShipperController extends BaseController<ShippersDto, Long>{
  private final ShippersService service;

  @Override
  public BaseService<ShippersDto, Long> getService() {
    return service;
  }  
}
