package com.learning.spring_learning.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "region", schema = "oe")
public class OeRegion {
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY) // nyalakan jika ingin generate otomatis
  @Column(name="region_id")
  private int regionId;

  @Column(name = "region_description")
  @Size(max = 60, message = "region_name maksimal 60 karakter")
  @NotBlank
  private String regionDescription;

  public OeRegion() {
  }

  public OeRegion(int regionId,
      @Size(max = 60, message = "region_name maksimal 60 karakter") @NotBlank String regionDescription) {
    this.regionId = regionId;
    this.regionDescription = regionDescription;
  }

  public String getRegionDescription() {
    return regionDescription;
  }

  public int getRegionId() {
    return regionId;
  }
  
}
