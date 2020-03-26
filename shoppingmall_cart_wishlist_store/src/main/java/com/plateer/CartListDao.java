package com.plateer;

import java.util.List;
import java.util.Map;

import com.plateer.domain.CartList;

public interface CartListDao {
	List<CartList> findCartList(String userId);
	void removeCart(String userId, String cartCode);
	void removeCartList(String userId, List<String> cartCodeList);
	void saveCart(CartList cartList);
	void modifyStock(CartList cartList);
}
