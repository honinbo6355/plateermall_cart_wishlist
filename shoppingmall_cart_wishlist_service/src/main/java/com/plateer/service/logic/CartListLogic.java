package com.plateer.service.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.CartListDao;
import com.plateer.domain.CardDiscountInfo;
import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.dto.SelectedOptionsDto;
import com.plateer.logic.CartListDaoImpl;
import com.plateer.service.CartListService;

@Service
public class CartListLogic implements CartListService {
	
	@Autowired
	private CartListDaoImpl cartListDao;
	
	public void addCart(CartListDto cartListDto) {
		cartListDto.setCartCode(UUID.randomUUID().toString());
		cartListDao.saveCart(cartListDto);
	}
	
	@Override
	public List<CartList> getCartList(String userId) {
		List<CartList> resultCartList = cartListDao.findCartList(userId);
		
		return resultCartList;
	}

	@Override
	public void deleteCart(CartList cart) {
		cartListDao.removeCart(cart);
	}

	@Override
	public void deleteCartList(List<CartList> cartList) {
		cartListDao.removeCartList(cartList);
	}

	public void changeQuantity(CartList cart) {
		cartListDao.modifyQuantity(cart);
	}

	public List<CardDiscountInfo> getCardDiscountInfo() {
		return cartListDao.findCardDiscountInfo();
	}
}
