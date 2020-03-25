package com.plateer.service;

import java.util.List;

import com.plateer.dto.CartListDto;

public interface CartListService {
	List<CartListDto> getCartList();
	void deleteCart(String cartCode);
	void deleteCartList(List<String> cartCodeList);
}
