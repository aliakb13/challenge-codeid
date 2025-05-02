package com.learning.spring_learning.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.spring_learning.entities.Region;
import com.learning.spring_learning.repository.RegionRepository;
import com.learning.spring_learning.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
  private final RegionRepository regionRepository;

  public RegionServiceImpl(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  @Override
  public List<Region> findAllCategory() {
    return regionRepository.findAll();
  }

  
}
