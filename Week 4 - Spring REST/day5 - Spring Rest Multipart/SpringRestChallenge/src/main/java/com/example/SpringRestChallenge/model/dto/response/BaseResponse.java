package com.example.SpringRestChallenge.model.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BaseResponse<T> {
  private final int code;
  private final String message;
  private final T data;
}
