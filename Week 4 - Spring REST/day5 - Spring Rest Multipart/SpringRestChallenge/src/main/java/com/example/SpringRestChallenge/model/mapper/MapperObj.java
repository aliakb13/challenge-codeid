package com.example.SpringRestChallenge.model.mapper;

import com.example.SpringRestChallenge.model.dto.CategoriesDto;
import com.example.SpringRestChallenge.model.dto.ShippersDto;
import com.example.SpringRestChallenge.model.dto.SupplierDto;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.model.entities.Categories;
import com.example.SpringRestChallenge.model.entities.Products;
import com.example.SpringRestChallenge.model.entities.Shippers;
import com.example.SpringRestChallenge.model.entities.Suppliers;

public class MapperObj {
  public static ShippersDto mapToShipperDto(Shippers shippers) {
    return new ShippersDto(shippers.getId(), shippers.getCompanyName(), shippers.getPhone());
  }

  public static CategoriesDto mapToCategoriesDto(Categories categories) {
    return new CategoriesDto(categories.getId(), categories.getName(), categories.getDescription());
  }

  public static SupplierDto mapToSupplierDto(Suppliers suppliers) {
    return new SupplierDto(suppliers.getId(), suppliers.getCompanyName());
  }

  public static ProductsDtoRes mapToProductsDto(Products products) {
    return new ProductsDtoRes(products.getId(),
                              products.getName(), 
                              products.getSupplier().getId(), 
                              products.getCategory().getId(), 
                              products.getPhoto(),
                              products.getCreatedDate());
  }
}
