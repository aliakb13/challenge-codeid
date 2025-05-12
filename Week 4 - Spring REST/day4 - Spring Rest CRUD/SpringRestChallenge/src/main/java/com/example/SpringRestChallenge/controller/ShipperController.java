package com.example.SpringRestChallenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringRestChallenge.service.ShippersService;
import com.example.SpringRestChallenge.service.impl.ShipperServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shippers")
public class ShipperController {
  private final ShippersService service;

  
}
