package com.plateer;

import java.util.List;

import com.plateer.dto.CartListDto;

public interface CartListDao {
	List<CartListDto> findCartList();
	void removeCart(String cartCode);
	void removeCartList(List<String> cartCodeList);
}
