package com.plateer.service.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.CartListDao;
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
	public List<CartListDto> getCartList(String userId) {
		List<CartListDto> resultCartList = new ArrayList<>();
		List<CartList> cartList = cartListDao.findCartList(userId);
		
		for (CartList goods : cartList) {
			CartListDto cartListDto = new CartListDto();
			String cartCode = goods.getCartCode();
			String goodsCode = goods.getGoodsCode();

			List<SelectedOptionsDto> selectedOptionsDto = cartListDao.findCartOption(cartCode, goodsCode);
			
			cartListDto.setCartCode(cartCode);
			cartListDto.setGoodsCode(goodsCode);
			cartListDto.setUserId(userId);
			cartListDto.setSelectedOptions(selectedOptionsDto);
			resultCartList.add(cartListDto);
		}
		
		return resultCartList;
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
