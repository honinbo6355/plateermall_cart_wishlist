package com.plateer.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartListDto {
	private String cartCode;
	private String userId;
	private String goodsCode;
	private List<SelectedOptionsDto> selectedOptions;
}
