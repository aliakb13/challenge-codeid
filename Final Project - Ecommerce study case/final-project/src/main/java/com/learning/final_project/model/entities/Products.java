package com.learning.final_project.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "oe")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(name = "product_name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Suppliers supplier;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Categories category;

  @Column(name = "quantity_per_unit")
  private String quantity;

  @Column(name = "unit_price")
  private Double price;

  @Column(name = "units_in_stock")
  private Integer stock;

  @Column(name = "units_on_order")
  private Integer unitOrder;

  @Column(name = "reorder_level")
  private Integer reoderLevel;

  @Column(name = "discontinued", nullable = false)
  private int discontinued;
}
