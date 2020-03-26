package com.plateer.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plateer.CartListDao;
import com.plateer.domain.CartList;
import com.plateer.mapper.CartListMapper;

@Repository
public class CartListDaoImpl implements CartListDao {

	@Autowired
	private CartListMapper cartListMapper;
	
	public List<CartList> findCartList(String userId) {
		return cartListMapper.findCartList(userId);
	}

	@Override
	public void removeCart(String userId, String cartCode) {
		cartListMapper.removeCart(userId, cartCode);
	}

	public void removeCartList(String userId, List<String> cartCodeList) {
		// userId도 넘겨야 하는데.. 일단 안되서 보류
		cartListMapper.removeCartList(cartCodeList);
	}

	public void saveCart(CartList cartList) {
		cartListMapper.saveCart(cartList);
	}

	public void modifyStock(CartList cartList) {
		cartListMapper.modifyStock(cartList);
	}
}
