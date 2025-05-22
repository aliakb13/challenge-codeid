package com.learning.final_project.model.entities.carts;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsId implements Serializable {
  @Column(name = "cart_id")
  private String cartId;

  @Column(name = "product_id")
  private Long productId;
}
