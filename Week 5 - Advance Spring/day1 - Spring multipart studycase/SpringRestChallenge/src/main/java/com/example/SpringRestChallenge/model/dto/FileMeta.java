package com.example.SpringRestChallenge.model.dto;

import org.springframework.web.multipart.MultipartFile;

public record FileMeta(
  String fileName,
  double fileSize,
  String contentType,
  String fileUri,
  MultipartFile originalFile
) {}

