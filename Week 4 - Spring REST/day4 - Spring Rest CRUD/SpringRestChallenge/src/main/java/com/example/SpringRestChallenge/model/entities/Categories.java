package com.example.SpringRestChallenge.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "oe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories extends BaseEntity {
  @Id
  @Column(name = "category_id")
  private long id;

  @Column(name = "category_name")
  private String name;

  @Column(name = "description")
  private String description;
}
