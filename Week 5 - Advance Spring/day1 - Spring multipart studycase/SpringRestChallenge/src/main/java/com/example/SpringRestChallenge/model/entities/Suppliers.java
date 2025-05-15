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
public class Suppliers extends BaseEntity{

  @Id
  @Column(name = "supplier_id")
  private long id;

  @Column(name = "company_name")
  private String companyName;
}
