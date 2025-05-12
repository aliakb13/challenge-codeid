package com.example.SpringRestChallenge.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShippersDto {

  @NotNull
  private long shipId;

  @Size(max = 40, message = "Cannot assign more than 40")
  private String companyName;

  @Size(max = 24, message = "Cannot assign more than 24")
  private String phone;
}
