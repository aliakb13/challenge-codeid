package com.example.SpringRestChallenge.model.dto.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ProductsDtoRes {
  private Long id;
  private String productName;
  private Long supplierId;
  private Long categoryId;
  private String photo;
  private Instant createdDate;
}
