package com.example.SpringRestChallenge.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductImagesRes {
  private String imageId;
  private String fileName;
  private Double fileSize;
  private String fileType;
  private String fileUri;
  private Long product_id;
}