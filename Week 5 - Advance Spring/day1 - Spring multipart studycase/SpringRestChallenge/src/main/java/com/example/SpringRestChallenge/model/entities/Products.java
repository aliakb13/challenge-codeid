package com.example.SpringRestChallenge.model.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "oe")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Products extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  @Column(name = "product_name")
  private String name;

  @JoinColumn(name = "supplier_id")
  @ManyToOne
  private Suppliers supplier;

  @JoinColumn(name = "category_id")
  @ManyToOne
  private Categories category;

  @Column(name = "quantity_per_unit")
  private String quantity;

  @Column(name = "unit_price")
  private Double unitPrice;

  @Column(name = "units_in_stock")
  private Long unitStock;

  @Column(name = "units_on_order")
  private Long unitOrder;

  @Column(name = "reorder_level")
  private Long reorderLvl;

  @Column(name = "discontinued")
  private Integer discontinued;

  @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<ProductImages> images;
}
