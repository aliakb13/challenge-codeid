package com.learning.final_project.model.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductResponse {
  private Long productId;
  private String productName;
  private Long supplierId;
  private Long categoryId;
  private String quantity;
  private Double price;
  private Integer stock;
  private Instant createdDate;
}