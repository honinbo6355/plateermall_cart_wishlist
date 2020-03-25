package com.plateer.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plateer.CartListDao;
import com.plateer.dto.CartListDto;
import com.plateer.mapper.CartListMapper;

@Repository
public class CartListDaoImpl implements CartListDao {

	@Autowired
	private CartListMapper cartListMapper;
	
	public List<CartListDto> findCartList() {
		return cartListMapper.findCartList();
	}

	@Override
	public void removeCart(String cartCode) {
		cartListMapper.removeCart(cartCode);
	}

	public void removeCartList(List<String> cartCodeList) {
		Map<String, List<String>> map = new HashMap<>();
		map.put("list", cartCodeList);
		cartListMapper.removeCartList(map);
	}
}
