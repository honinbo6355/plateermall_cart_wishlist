package com.plateer.service;

import java.util.List;

import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;

public interface CartListService {
	List<CartListDto> getCartList(String userId);
	void deleteCart(String userId, String cartCode);
	void deleteCartList(String userId, List<String> cartCodeList);
	void addCart(CartListDto cartListDto);
	void changeStock(CartList cartList);
}
