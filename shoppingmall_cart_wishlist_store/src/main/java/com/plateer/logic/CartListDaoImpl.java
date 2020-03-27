package com.plateer.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plateer.CartListDao;
import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.dto.SelectedOptionsDto;
import com.plateer.mapper.CartListMapper;
import com.plateer.mapper.CartOptionMapper;

@Repository
public class CartListDaoImpl implements CartListDao {

	@Autowired
	private CartListMapper cartListMapper;
	
	@Autowired
	private CartOptionMapper cartOptionMapper;
	
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

	public void saveCart(CartListDto cartListDto) {
		System.out.println(cartListDto);
		cartListMapper.saveCart(cartListDto);
		
		for (SelectedOptionsDto selectedOptionsDto : cartListDto.getSelectedOptions()) {
			Map<String, Object> cartOptionMap = new HashMap<>();
			cartOptionMap.put("cartCode", cartListDto.getCartCode());
			cartOptionMap.put("goodsCode", cartListDto.getGoodsCode());
			cartOptionMap.put("selectedOptionsDto", selectedOptionsDto);
			
			cartOptionMapper.saveCartOption(cartOptionMap);
		}
	}

	public void modifyStock(CartList cartList) {
		cartListMapper.modifyStock(cartList);
	}

	public List<SelectedOptionsDto> findCartOption(String cartCode, String goodsCode) {
		return cartOptionMapper.findCartOption(cartCode, goodsCode);
	}
}
