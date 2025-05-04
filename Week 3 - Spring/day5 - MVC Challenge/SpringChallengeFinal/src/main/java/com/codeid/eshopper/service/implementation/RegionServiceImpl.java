package com.codeid.eshopper.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.codeid.eshopper.entities.Region;
import com.codeid.eshopper.repository.RegionRepository;
import com.codeid.eshopper.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
    //kita gunakan untuk inject ke constructor
    private final RegionRepository repository;

    //depency injection
    public RegionServiceImpl(RegionRepository repository) {
        // loose-couple
        this.repository = repository;

        // contoh tight-couple
        //this.repository = new RegionRepository(); 
            
        
    }

    @Override
    public List<Region> findAllCategory() {
        return repository.findAll();
    }

    @Override
    public Region addRegion(Region region) {
        return repository.save(region);
    }

    @Override
    public Optional<Region> findRegionById(Long regionId) {
       return repository.findById(regionId);
    }

    @Override
    public void deleteRegionById(Long regionId) {
        Region region = repository.findById(regionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(region);
    }
    
}
