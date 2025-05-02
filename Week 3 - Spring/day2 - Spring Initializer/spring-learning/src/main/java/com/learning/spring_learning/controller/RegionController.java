package com.learning.spring_learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring_learning.service.RegionService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("region")
public class RegionController {
  
  private final RegionService service;

  

  public RegionController(RegionService service) {
    this.service = service;
  }

  @GetMapping("")
  public String getAllRegion(Model model) {
      model.addAttribute("regions", service.findAllCategory());
      return "region";
  }
  
}
