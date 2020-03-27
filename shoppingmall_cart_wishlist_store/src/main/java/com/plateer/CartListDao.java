package com.plateer;

import java.util.List;
import java.util.Map;

import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.dto.SelectedOptionsDto;

public interface CartListDao {
	List<CartList> findCartList(String userId);
	void removeCart(String userId, String cartCode);
	void removeCartList(String userId, List<String> cartCodeList);
	void saveCart(CartListDto cartListDto);
	void modifyStock(CartList cartList);
	List<SelectedOptionsDto> findCartOption(String cartCode, String goodsCode);
}
