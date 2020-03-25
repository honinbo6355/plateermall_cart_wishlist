package com.plateer.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.CartListDao;
import com.plateer.dto.CartListDto;
import com.plateer.logic.CartListDaoImpl;
import com.plateer.service.CartListService;

@Service
public class CartListLogic implements CartListService {
	
	@Autowired
	private CartListDaoImpl cartListDao;
	
	@Override
	public List<CartListDto> getCartList() {
		return cartListDao.findCartList();
	}

	@Override
	public void deleteCart(String cartCode) {
		cartListDao.removeCart(cartCode);
	}

	@Override
	public void deleteCartList(List<String> cartCodeList) {
		cartListDao.removeCartList(cartCodeList);
	}
}
