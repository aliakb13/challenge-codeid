package com.example.SpringRestChallenge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringRestChallenge.model.dto.FileMeta;
import com.example.SpringRestChallenge.model.dto.request.ProductsDtoReq;
import com.example.SpringRestChallenge.model.dto.response.BaseResponse;
import com.example.SpringRestChallenge.model.dto.response.ProductImagesRes;
import com.example.SpringRestChallenge.model.dto.response.ProductsDtoRes;
import com.example.SpringRestChallenge.service.FileStorageService;
import com.example.SpringRestChallenge.service.impl.ProductImageServiceImpl;
import com.example.SpringRestChallenge.service.impl.ProductsServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController{
  private final ProductsServiceImpl productService;
  private final FileStorageService fileStorageService;
  private final ProductImageServiceImpl imageService;

  @GetMapping("")
  public ResponseEntity<?> getAllData() {
    return ResponseEntity.ok(new BaseResponse<List<ProductsDtoRes>>(1220, "successfully get all data!", productService.getAllData()));
  }
  
  // @PostMapping("")
  // public ResponseEntity<?> createData(@RequestBody @Valid ProductsDtoReq entity) {
  //    try {
  //     return ResponseEntity.status(201).body(new BaseResponse<ProductsDtoRes>(999, "successfully created", productService.addData(entity)));
  //   } catch (EntityNotFoundException e) {
  //     return ResponseEntity.status(409).body(new BaseResponse<String>(1700,e.getMessage(), null));
  //   }
  // }

  @GetMapping("/{id}")
  public ResponseEntity<?> getDataById(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(new BaseResponse<ProductsDtoRes>(1220, "Success get data!", productService.findDataById(id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404)
        .body(new BaseResponse<String>(1500,e.getMessage(),null));
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editData(@PathVariable Long id, @RequestBody @Valid ProductsDtoReq entity) {
    try {
      return ResponseEntity.ok(new BaseResponse<ProductsDtoRes>(
      1100, "success edit data!", productService.updateData(entity, id)));
    } catch(EntityNotFoundException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteData(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(new BaseResponse<Long>(
        1220, "success deleting data with id " + productService.delete(id) + "!", null));
    } catch(IllegalStateException e) {
      return ResponseEntity.status(404).body(new BaseResponse<String>
      (1500, e.getMessage(), null));
    }
  }

  @PostMapping(consumes = {"multipart/form-data"}, value = "/upload")
  public ResponseEntity<?> createMultipart(
    @RequestPart("data") ProductsDtoReq dto,
    @RequestPart(value = "file", required = false) MultipartFile file){
      if (file.isEmpty()) {
      return ResponseEntity.badRequest().body("please upload employee photo");
    }

    try {
      // gaada pencegahan apakah id supplier atau category ada atau tidak, file PASTI masuk!
      String fileName = fileStorageService.storeFileWithRandomName(file);
      // dto.setPhoto(fileName);
      var addedData = productService.addData(dto, file, fileName);
      return ResponseEntity.ok(addedData);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(Collections.singletonMap("error", e.getMessage()));
    }
  }
  
  @GetMapping("/view/{fileName:.+}")
  public ResponseEntity<?> viewImage(@PathVariable String fileName) {
     try {
            Resource resource = fileStorageService.loadFile(fileName);
            
            // Cek jika file adalah image
            String contentType = determineContentType(fileName);
            
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, 
                           "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
  }

  @GetMapping("/images")
  public ResponseEntity<?> getAllPhotosData() {
      return ResponseEntity.ok(new BaseResponse<List<ProductImagesRes>>(5000,"Successfully get images data!", imageService.getAllData()));
  }
  

  public String determineContentType(String fileName) {
      // Implementasi sederhana - bisa diganti dengan cara yang lebih robust
      if (fileName.toLowerCase().endsWith(".png")) {
          return "image/png";
      } else if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")) {
          return "image/jpeg";
      } else if (fileName.toLowerCase().endsWith(".gif")) {
          return "image/gif";
      }
      return "application/octet-stream";
  }

  @PostMapping(value = "/upload/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<?> bulkInsert(
    @RequestPart("data") ProductsDtoReq dto,
    @RequestPart("photos") List<MultipartFile> files) throws Exception {

  if (files == null || files.isEmpty()) {
    return ResponseEntity.badRequest().body("Please upload at least one photo");
  }

  List<FileMeta> fileMetas = new ArrayList<>();

  try {
    for (MultipartFile file : files) {
      String fileName = fileStorageService.storeFileWithRandomName(file);
      double size = (double) file.getSize() / (1024 * 1024);
      String contentType = file.getContentType();
      String uri = "/images/" + fileName;

      fileMetas.add(new FileMeta(fileName, size, contentType, uri, file));
    }

    var addedData = productService.bulkInsert(dto, fileMetas);
    return ResponseEntity.ok(addedData);
  } catch (IOException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(Collections.singletonMap("error", "Gagal menyimpan salah satu file: " + e.getMessage()));
  }
}
    
}
