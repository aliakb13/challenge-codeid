package com.example.SpringRestChallenge.model.dto.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InsertImagesReq {
  private ProductsDtoReq productReq;
  private List<MultipartFile> photos;
}
