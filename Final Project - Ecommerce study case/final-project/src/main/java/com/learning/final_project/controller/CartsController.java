package com.learning.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.final_project.model.entities.carts.Carts;
import com.learning.final_project.model.request.AddItemRequest;
import com.learning.final_project.model.response.CartResponse;
import com.learning.final_project.model.response.handling.BaseResponse;
import com.learning.final_project.service.BaseCrudService;
import com.learning.final_project.service.CartService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartsController extends BaseCrudController<CartResponse, String, CartResponse> {
  private final CartService cartService;

  @PostMapping("/add-item")
  public ResponseEntity<?> addItemToCart(@RequestBody AddItemRequest entity) {

    CartResponse saved = cartService.addItemToChartItems(entity);
    // CartResponse response = cartService.mapToDto(saved);

    return ResponseEntity.ok(BaseResponse.<CartResponse>builder()
        .statusCode(HttpStatus.OK)
        .message("Item berhasil ditambahkan ke cart")
        .data(saved)
        .build());
  }

  @DeleteMapping("/{cartId}/items/{cartItem}")
  public ResponseEntity<?> deleteItemOnCart(@PathVariable String cartId, @PathVariable Long cartItem) {
    return ResponseEntity.ok(
      BaseResponse.<String>builder()
        .statusCode(HttpStatus.OK)
        .message("Item berhasil dihapus dari cart")
        .data("Item with id " + cartService.deleteItemOnCart(cartId, cartItem) + " successfully deleted")
        .build()
    );
  }

  @Override
  public BaseCrudService<CartResponse, String, CartResponse> getService() {
    return cartService;
  }
  
}
