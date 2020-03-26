package com.plateer.logic;

import java.util.List;

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
		//
		for(String cartCode : cartCodeList) {
			cartListMapper.removeCart(userId, cartCode);
		}
	}

	public void saveCart(CartList cartList) {
		cartListMapper.saveCart(cartList);
	}

	public void modifyStock(CartList cartList) {
		cartListMapper.modifyStock(cartList);
	}
}
