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

@Repository
public class CartListDaoImpl implements CartListDao {

	@Autowired
	private CartListMapper cartListMapper;
	
	public List<CartList> findCartList(String userId) {
		return cartListMapper.findCartList(userId);
	}

	@Override
	public void removeCart(CartList cart) {
		cartListMapper.removeCart(cart);
	}

	public void removeCartList(List<CartList> cartList) {
		for(CartList cart : cartList) {
			cartListMapper.removeCart(cart);
		}
	}

	public void saveCart(CartListDto cartListDto) {
		System.out.println(cartListDto);
		
		for (SelectedOptionsDto selectedOptionsDto : cartListDto.getSelectedOptions()) {
			Map<String, Object> cartOptionMap = new HashMap<>();
			cartOptionMap.put("cartCode", cartListDto.getCartCode());
			cartOptionMap.put("goodsCode", cartListDto.getGoodsCode());
			cartOptionMap.put("userId", cartListDto.getUserId());
			cartOptionMap.put("text", selectedOptionsDto.getText());			
			cartOptionMap.put("quantity", selectedOptionsDto.getQuantity());
			
			cartListMapper.saveCart(cartOptionMap);
		}
	}

	public void modifyQuantity(CartList cart) {
		cartListMapper.modifyQuantity(cart);
	}
}
