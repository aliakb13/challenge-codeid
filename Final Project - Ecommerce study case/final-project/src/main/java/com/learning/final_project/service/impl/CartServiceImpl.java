package com.learning.final_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learning.final_project.model.entities.Products;
import com.learning.final_project.model.entities.Users;
import com.learning.final_project.model.entities.carts.CartItems;
import com.learning.final_project.model.entities.carts.CartItemsId;
import com.learning.final_project.model.entities.carts.Carts;
import com.learning.final_project.model.mapper.MapperObj;
import com.learning.final_project.model.request.AddItemRequest;
import com.learning.final_project.model.response.CartResponse;
import com.learning.final_project.repository.CartItemsRepository;
import com.learning.final_project.repository.CartRepository;
import com.learning.final_project.repository.ProductRepository;
import com.learning.final_project.repository.UserRepository;
import com.learning.final_project.service.CartService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
  private final CartRepository cartRepository;
  private final CartItemsRepository cartItemsRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  @Override
  public List<CartResponse> getAllData() {
    return cartRepository.findAll().stream().map(MapperObj::mapToCartResponse).toList();
  }

  @Override
  public CartResponse addData(CartResponse entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addData'");
  }

  @Override
  public CartResponse findById(String id) {
    return cartRepository.findById(id).map(MapperObj::mapToCartResponse).orElseThrow(() -> new EntityNotFoundException("Cart tidak ditemukan"));
  }

  @Override
  public CartResponse updateData(CartResponse entity, String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public String deleteData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
  }

 @Override
public CartResponse addItemToChartItems(AddItemRequest request) {
    Users user = userRepository.findById(request.getUserId())
        .orElseThrow(() -> new EntityNotFoundException("User tidak ditemukan"));

    // Cari cart milik user
    Carts cart = cartRepository.findCartByUserId(user.getId())
        .orElseGet(() -> {
            Carts newCart = Carts.builder()
                    .id(UUID.randomUUID().toString())
                    .user(user)
                    .items(new ArrayList<>())
                    .build();
            return cartRepository.save(newCart);
        });

    // Cek apakah produk ada di cart_items
    CartItemsId cartItemsId = new CartItemsId(cart.getId(), request.getProductId());
    Optional<CartItems> optionalCartItem = cartItemsRepository.findById(cartItemsId);

    if (optionalCartItem.isPresent()) {
        CartItems existingItem = optionalCartItem.get();
        existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
        cartItemsRepository.save(existingItem);
    } else {
        Products product = productRepository.findById(request.getProductId())
            .orElseThrow(() -> new EntityNotFoundException("Product tidak ditemukan"));

        CartItems newItem = CartItems.builder()
                .id(cartItemsId)
                .cart(cart)
                .product(product)
                .quantity(request.getQuantity())
                .price(product.getPrice())
                .discount(0.0)
                .build();

        // cart.getItems().add(newItem);
        cartItemsRepository.save(newItem); // atau bisa langsung cascade saat save cart jika diaktifkan
    }

    return MapperObj.mapToCartResponse(cartRepository.findById(cart.getId()).orElseThrow());
  }

 @Override
 public Long deleteItemOnCart(String cartId, Long cartItemId) {
  cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart tidak ditemukan!"));

  var item = cartItemsRepository.findProductInCartItems(cartId, cartItemId);

  cartItemsRepository.delete(item.get());
  return cartItemId;
 }
}
