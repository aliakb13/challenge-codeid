package com.example.SpringRestChallenge.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplierDto {

  @NotNull
  private long supplierId;
  
  @Size(max = 40, message = "Cannot contain more than 40!")
  private String companyName;
}
