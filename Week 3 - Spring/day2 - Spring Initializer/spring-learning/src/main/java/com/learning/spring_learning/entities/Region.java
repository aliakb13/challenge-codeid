package com.learning.spring_learning.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "regions", schema = "hr")
public class Region {

  @Id
  @GeneratedValue
  @Column(name = "region_id")
  private int regionId;

  @Column(name = "region_name")
  @Size(max = 25, message = "region_name maksimal 25 karakter")
  @NotBlank
  private String regionName;

  
  public Region() {
  }

  public Region(int regionId,
      @Size(max = 25, message = "region_name maksimal 25 karakter") @NotBlank String regionName) {
    this.regionId = regionId;
    this.regionName = regionName;
  }

  public int getRegionId() {
    return regionId;
  }

  public String getRegionName() {
    return regionName;
  }

}
