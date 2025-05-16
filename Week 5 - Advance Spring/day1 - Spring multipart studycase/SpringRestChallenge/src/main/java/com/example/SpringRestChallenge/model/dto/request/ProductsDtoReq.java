package com.example.SpringRestChallenge.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductsDtoReq {

  @NotNull
  @Size(max = 40, message = "cannot contain more than 40")
  private String productName;

  @NotNull
  private Long supplierId;

  @NotNull
  private Long categoryId;

  private Double unitPrice;
}
