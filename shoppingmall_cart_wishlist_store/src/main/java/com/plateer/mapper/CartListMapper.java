package com.plateer.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.plateer.dto.CartListDto;

@Mapper
public interface CartListMapper {
	List<CartListDto> findCartList();

	void removeCart(String cartCode);

	void removeCartList(Map<String, List<String>> map);
}
