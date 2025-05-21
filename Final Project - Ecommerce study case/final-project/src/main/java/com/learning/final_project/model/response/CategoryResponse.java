package com.learning.final_project.model.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
  private Long categoryId;
  private String categoryName;
  private String description;
  private Instant createdDate;
  private Instant modifiedDate;
}
