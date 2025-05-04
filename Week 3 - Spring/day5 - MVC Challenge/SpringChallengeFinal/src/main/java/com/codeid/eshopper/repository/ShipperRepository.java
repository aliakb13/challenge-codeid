package com.codeid.eshopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeid.eshopper.entities.Shipper;
@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Long>{
    
}
