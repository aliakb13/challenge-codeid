package com.example.SpringRestChallenge.service.impl;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringRestChallenge.model.dto.FileMeta;
import com.example.SpringRestChallenge.model.dto.request.InsertImagesReq;
import com.example.SpringRestChallenge.model.dto.request.ProductsDtoReq;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.model.entities.ProductImages;
import com.example.SpringRestChallenge.model.entities.Products;
import com.example.SpringRestChallenge.model.mapper.MapperObj;
import com.example.SpringRestChallenge.repository.CategoriesRepository;
import com.example.SpringRestChallenge.repository.ProductImagesRepository;
import com.example.SpringRestChallenge.repository.ProductsRepository;
import com.example.SpringRestChallenge.repository.SupplierRepository;
import com.example.SpringRestChallenge.service.FileStorageService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl{

  private final ProductsRepository productsRepository;
  private final SupplierRepository supplierRepository;
  private final CategoriesRepository categoriesRepository;
  private final FileStorageService fileStorageService;
  
  public List<ProductsDtoRes> getAllData() {
    return productsRepository.findAll().stream().map(MapperObj::mapToProductsDto).collect(Collectors.toList());
  }

  // public ProductsDtoRes addData(ProductsDtoReq entity) {
  //   var supplier = supplierRepository.findById(entity.getSupplierId()).orElseThrow(() -> new EntityNotFoundException("supplier with id " + entity.getSupplierId() + " was not found!"));
  //   var category = categoriesRepository.findById(entity.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("category with id " + entity.getCategoryId() + " was not found!"));

  //   var products = Products.builder()
  //                           .name(entity.getProductName())
  //                           .supplier(supplier)
  //                           .category(category)
  //                           .quantity("contain something")
  //                           .unitPrice(entity.getUnitPrice())
  //                           .unitStock(50L)
  //                           .unitOrder(100L)
  //                           .reorderLvl(50L)
  //                           .discontinued(new Random().nextInt(0,1))
  //                           .build();

  
  //   return MapperObj.mapToProductsDto(productsRepository.save(products));
  // }

  public ProductsDtoRes findDataById(Long id) {
    return productsRepository.findById(id).map(MapperObj::mapToProductsDto).orElseThrow(() -> new EntityNotFoundException("supplier with id " + id + " was not found!"));
  }

  public ProductsDtoRes updateData(ProductsDtoReq entity, Long id) {
    var product = productsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("products with id " + id + " was not found!"));

    var supplier = supplierRepository.findById(entity.getSupplierId()).orElseThrow(() -> new EntityNotFoundException("supplier with id " + entity.getSupplierId() + " was not found!"));
    var category = categoriesRepository.findById(entity.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("category with id " + entity.getCategoryId() + " was not found!"));

    product.setName(entity.getProductName());
    product.setSupplier(supplier);
    product.setCategory(category);
    product.setUnitPrice(entity.getUnitPrice());
    // product.setPhoto(entity.getPhoto());
    product.setModifiedDate(Instant.now());
    
    return MapperObj.mapToProductsDto(productsRepository.save(product));
  }

  public Long delete(Long id) {
    var product = productsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("products with id " + id + " was not found!"));

    productsRepository.delete(product);

    return id;
  }

  public ProductsDtoRes addData(ProductsDtoReq entity, MultipartFile image, String filename) {
    var supplier = supplierRepository.findById(entity.getSupplierId()).orElseThrow(() -> new EntityNotFoundException("supplier with id " + entity.getSupplierId() + " was not found!"));
    var category = categoriesRepository.findById(entity.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("category with id " + entity.getCategoryId() + " was not found!"));

    var products = Products.builder()
                            .name(entity.getProductName())
                            .supplier(supplier)
                            .category(category)
                            .quantity("contain something")
                            .unitPrice(entity.getUnitPrice())
                            .unitStock(50L)
                            .unitOrder(100L)
                            .reorderLvl(50L)
                            .discontinued(new Random().nextInt(0,1))
                            .images(new ArrayList<>())
                            .build();
    
    String id = "image-" + UUID.randomUUID().toString();
    String uri = "localhost:8080/";
    double size = (double) image.getSize() / (1024 * 1024);
    String contentType = image.getContentType();
    var imageData = ProductImages.builder().imageId(id).fileName(filename).fileSize(size).fileType(contentType).fileUri(uri).products(products).build();

    products.getImages().add(imageData);
    
    return MapperObj.mapToProductsDto(productsRepository.save(products));
  }
  
  public ProductsDtoRes bulkInsert(ProductsDtoReq entity, List<FileMeta> fileMetas) {
  var supplier = supplierRepository.findById(entity.getSupplierId())
      .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
  var category = categoriesRepository.findById(entity.getCategoryId())
      .orElseThrow(() -> new EntityNotFoundException("Category not found"));

  var products =  Products.builder()
                            .name(entity.getProductName())
                            .supplier(supplier)
                            .category(category)
                            .quantity("contain something")
                            .unitPrice(entity.getUnitPrice())
                            .unitStock(50L)
                            .unitOrder(100L)
                            .reorderLvl(50L)
                            .discontinued(new Random().nextInt(0,1))
                            .images(new ArrayList<>())
                            .build();

  for (FileMeta meta : fileMetas) {
    ProductImages image = ProductImages.builder()
        .imageId(UUID.randomUUID().toString())
        .fileName(meta.fileName())
        .fileSize(meta.fileSize())
        .fileType(meta.contentType())
        .fileUri(meta.fileUri())
        .products(products)
        .build();

    products.getImages().add(image);
  }

  return MapperObj.mapToProductsDto(productsRepository.save(products));
}
  
}
