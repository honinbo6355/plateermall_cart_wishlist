package com.plateer.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartListDto {
    private String cartCode;
    private String userId;
    private int cartStock;

    private String goodsCode;
}
