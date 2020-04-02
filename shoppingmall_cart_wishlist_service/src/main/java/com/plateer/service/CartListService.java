package com.plateer.service;

import java.util.List;

import com.plateer.domain.CardDiscountInfo;
import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;

public interface CartListService {
	List<CartList> getCartList(String userId);
	void deleteCart(CartList cart);
	void deleteCartList(List<CartList> cartList);
	void addCart(CartListDto cartListDto);
	void changeQuantity(CartList cart);
	List<CardDiscountInfo> getCardDiscountInfo();
}
