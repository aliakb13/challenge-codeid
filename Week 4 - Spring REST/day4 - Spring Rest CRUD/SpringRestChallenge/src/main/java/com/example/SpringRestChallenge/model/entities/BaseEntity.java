package com.example.SpringRestChallenge.model.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

  @Column(name = "created_date")
  private Instant createdDate = Instant.now();

  @Column(name = "modified_date")
  private Instant modifiedDate;

}
