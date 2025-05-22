package com.learning.final_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.final_project.model.entities.carts.CartItems;
import com.learning.final_project.model.entities.carts.CartItemsId;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, CartItemsId>{
  @Query("SELECT ci FROM CartItems ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
  Optional<CartItems> findProductInCartItems(String cartId, Long productId);
}
