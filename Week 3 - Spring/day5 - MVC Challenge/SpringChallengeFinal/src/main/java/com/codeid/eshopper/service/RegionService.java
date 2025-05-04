package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Region;

public interface RegionService {

    //'select * from hr.regions'
    List<Region> findAllCategory();

    Region addRegion(Region region);

    Optional<Region> findRegionById(Long regionId);

    void deleteRegionById(Long regionId);
}
