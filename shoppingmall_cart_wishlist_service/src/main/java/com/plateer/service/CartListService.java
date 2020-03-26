package com.plateer.service;

import java.util.List;

import com.plateer.domain.CartList;

public interface CartListService {
	List<CartList> getCartList(String userId);
	void deleteCart(String userId, String cartCode);
	void deleteCartList(String userId, List<String> cartCodeList);
	void addCart(CartList cartList);
	void changeStock(CartList cartList);
}
