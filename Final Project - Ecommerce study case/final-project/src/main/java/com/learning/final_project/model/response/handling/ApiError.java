package com.learning.final_project.model.response.handling;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiError {
  private HttpStatus status;
  private String message;
  @Builder.Default
  private Instant timestamp = Instant.now();
}
