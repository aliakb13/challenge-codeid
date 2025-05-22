package com.learning.final_project.service;
import com.learning.final_project.model.request.AddItemRequest;
import com.learning.final_project.model.response.CartResponse;

public interface CartService extends BaseCrudService<CartResponse, String, CartResponse>{
  CartResponse addItemToChartItems(AddItemRequest entity);
  Long deleteItemOnCart(String cartId, Long cartItemId);
}
