package com.plateer;

import java.util.List;
import java.util.Map;

import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.dto.SelectedOptionsDto;

public interface CartListDao {
	List<CartList> findCartList(String userId);
	void removeCart(CartList cart);
	void removeCartList(String userId, List<CartList> cartList);
	void saveCart(CartListDto cartListDto);
	void modifyQuantity(CartList cart);
}
