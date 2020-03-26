package com.plateer.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartList {
	//
    private String cartCode;
    private String userId;
    private int cartStock;

    private String goodsCode;
    
    
}
