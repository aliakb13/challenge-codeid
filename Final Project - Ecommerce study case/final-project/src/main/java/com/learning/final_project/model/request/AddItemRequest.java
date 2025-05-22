package com.learning.final_project.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddItemRequest {
  @NotNull
  private Long userId;
  
  @NotNull
  private Long productId;

  private Integer quantity;
}
