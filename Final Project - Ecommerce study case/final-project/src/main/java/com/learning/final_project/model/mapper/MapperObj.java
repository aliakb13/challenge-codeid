package com.learning.final_project.model.mapper;

import java.util.stream.Collectors;

import com.learning.final_project.model.entities.Categories;
import com.learning.final_project.model.entities.Products;
import com.learning.final_project.model.entities.Suppliers;
import com.learning.final_project.model.entities.carts.Carts;
import com.learning.final_project.model.response.CartItemResponse;
import com.learning.final_project.model.response.CartResponse;
import com.learning.final_project.model.response.CategoryResponse;
import com.learning.final_project.model.response.ProductResponse;
import com.learning.final_project.model.response.SupplierResponse;

public class MapperObj {
  public static CategoryResponse mapToCategoryRes(Categories category) {
    return CategoryResponse.builder()
      .categoryId(category.getId())
      .categoryName(category.getName())
      .description(category.getDescription())
      .createdDate(category.getCreatedDate())
      .modifiedDate(category.getModifiedDate())
      .build();
  }

  public static SupplierResponse mapToSupplierRes(Suppliers supplier) {
    return SupplierResponse.builder()
      .supplierId(supplier.getId())
      .companyName(supplier.getCompanyName())
      .createdDate(supplier.getCreatedDate())
      .modifiedDate(supplier.getModifiedDate())
      .build();
  }

  public static ProductResponse mapToProductResponse(Products product) {
    return ProductResponse.builder()
      .productId(product.getId())
      .productName(product.getName())
      .supplierId(product.getSupplier().getId())
      .categoryId(product.getCategory().getId())
      .quantity(product.getQuantity())
      .price(product.getPrice())
      .stock(product.getStock())
      .createdDate(product.getCreatedDate())
      .build();
  }

  public static CartResponse mapToCartResponse(Carts cart) {
    return CartResponse.builder()
        .cartId(cart.getId())
        .userId(cart.getUser().getId())
        .items(
            cart.getItems().stream()
                .map(item -> CartItemResponse.builder()
                    .productId(item.getProduct().getId())
                    .productName(item.getProduct().getName())
                    .price(item.getPrice())
                    .quantity(item.getQuantity())
                    .discount(item.getDiscount())
                    .build()
                ).collect(Collectors.toList())
        )
        .build();
  }
}
