package com.example.SpringRestChallenge.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImagesReq {
  @NotNull
  private Long productId;
}
