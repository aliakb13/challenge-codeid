package com.learning.final_project.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemResponse {
  private Long productId;
  private String productName;
  private Double price;
  private Integer quantity;
  private Double discount;
}
