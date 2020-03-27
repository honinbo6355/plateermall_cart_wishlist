package com.plateer.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.plateer.dto.SelectedOptionsDto;

@Mapper
public interface CartOptionMapper {

	void saveCartOption(Map<String, Object> cartOptionMap);
	
	List<SelectedOptionsDto> findCartOption(@Param("cartCode") String cartCode, @Param("goodsCode") String goodsCode);	
}
