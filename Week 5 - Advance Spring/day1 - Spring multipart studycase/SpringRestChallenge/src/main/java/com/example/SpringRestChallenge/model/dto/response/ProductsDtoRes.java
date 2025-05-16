package com.example.SpringRestChallenge.model.dto.response;

import java.time.Instant;
import java.util.List;

import com.example.SpringRestChallenge.model.dto.request.InsertImagesReq;
import com.example.SpringRestChallenge.model.entities.ProductImages;

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
  private List<ProductImages> photo;
  private Instant createdDate;
}
