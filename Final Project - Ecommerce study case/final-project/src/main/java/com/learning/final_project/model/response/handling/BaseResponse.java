package com.learning.final_project.model.response.handling;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse<T> {
  private HttpStatus statusCode;
  private String message;
  private T data;

  @Builder.Default
  private Instant timestamp = Instant.now();
}
