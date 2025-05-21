package com.learning.final_project.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
  @NotNull
  @Size(max = 40, message = "cannot contain more than 40")
  private String productName;

  @NotNull
  private Long supplierId;

  @NotNull
  private Long categoryId;

  private Double unitPrice;
}
