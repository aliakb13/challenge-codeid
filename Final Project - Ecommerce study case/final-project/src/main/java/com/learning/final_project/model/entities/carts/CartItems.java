package com.learning.final_project.model.entities.carts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.learning.final_project.model.entities.BaseEntity;
import com.learning.final_project.model.entities.Products;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items", schema = "oe")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItems extends BaseEntity {

  @EmbeddedId
  private CartItemsId id;
  
  @ManyToOne
  @JoinColumn(name = "cart_id")
  @MapsId("cartId")
  private Carts cart;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @MapsId("productId")
  @JsonBackReference
  private Products product;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "unit_price")
  private Double price;

  @Column(name = "discount")
  private Double discount;
}
