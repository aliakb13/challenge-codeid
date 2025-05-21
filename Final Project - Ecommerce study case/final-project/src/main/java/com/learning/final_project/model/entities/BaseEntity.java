package com.learning.final_project.model.entities;
import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
  @Column(name = "created_date", nullable = false)
  private Instant createdDate = Instant.now();

  @Column(name = "modified_date")
  private Instant modifiedDate;
}
