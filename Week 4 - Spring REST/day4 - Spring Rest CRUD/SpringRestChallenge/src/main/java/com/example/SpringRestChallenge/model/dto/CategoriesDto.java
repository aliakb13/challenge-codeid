package com.example.SpringRestChallenge.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriesDto {
  @NotNull
  private long categoryId;

  @Size(max = 15, message = "value must less than or equal to 15")
  private String categoryName;
  private String categoryDescription;
}
