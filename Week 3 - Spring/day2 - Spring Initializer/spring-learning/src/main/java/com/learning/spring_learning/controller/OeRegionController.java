package com.learning.spring_learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring_learning.entities.OeRegion;
import com.learning.spring_learning.repository.OeRegionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("oe")
public class OeRegionController {
  private final OeRegionRepository repository;

  public OeRegionController(OeRegionRepository repository) {
    this.repository = repository;
  }

  @PostMapping("regions")
  public OeRegion postMethodName(@RequestBody OeRegion region) {
      //TODO: process POST request
      
      return repository.save(region);
  }

  @GetMapping("regions")
  public String getMethodName(Model model) {
      model.addAttribute("regions", repository.findAll());
      return "oeregion";
  }
  
  
}
