package com.plateer.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.dto.SelectedOptionsDto;

@Mapper
public interface CartListMapper {
	List<CartList> findCartList(String userId);

	void removeCart(@Param("userId") String userId, @Param("cartCode") String cartCode);

	//void removeCartList(Map<String, Object> paramMap);

	void saveCart(CartListDto cartListDto);

	void modifyStock(CartList cartList);
}
