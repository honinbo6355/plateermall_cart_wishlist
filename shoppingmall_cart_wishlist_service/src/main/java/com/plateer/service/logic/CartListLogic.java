package com.plateer.service.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.CartListDao;
import com.plateer.domain.CartList;
import com.plateer.logic.CartListDaoImpl;
import com.plateer.service.CartListService;

@Service
public class CartListLogic implements CartListService {
	
	@Autowired
	private CartListDaoImpl cartListDao;
	
	public void addCart(CartList cartList) {
		cartList.setCartCode(UUID.randomUUID().toString());
		cartListDao.saveCart(cartList);
	}
	
	@Override
	public List<CartList> getCartList(String userId) {
		return cartListDao.findCartList(userId);
	}

	@Override
	public void deleteCart(String userId, String cartCode) {
		cartListDao.removeCart(userId, cartCode);
	}

	@Override
	public void deleteCartList(String userId, List<String> cartCodeList) {
		cartListDao.removeCartList(userId, cartCodeList);
	}

	public void changeStock(CartList cartList) {
		cartListDao.modifyStock(cartList);
	}
}
