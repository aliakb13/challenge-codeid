package com.example.SpringRestChallenge.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringRestChallenge.model.dto.CategoriesDto;
import com.example.SpringRestChallenge.service.BaseService;
import com.example.SpringRestChallenge.service.CategoriesService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController extends BaseController<CategoriesDto, Long> {

  private final CategoriesService service;

  @Override
  public BaseService<CategoriesDto, Long> getService() {
    return service;
  }
}
