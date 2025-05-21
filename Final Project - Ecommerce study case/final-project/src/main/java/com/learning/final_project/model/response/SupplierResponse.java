package com.learning.final_project.model.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SupplierResponse {
  private Long supplierId;
  private String companyName;
  private Instant createdDate;
  private Instant modifiedDate;
}
