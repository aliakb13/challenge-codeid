package com.learning.final_project.model.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponse {
  private String cartId;
  private Long userId;
  private List<CartItemResponse> items;
}
