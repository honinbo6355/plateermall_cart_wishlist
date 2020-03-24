package com.plateer;

import com.plateer.dto.CartListDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
@RequestMapping("/api/cart")
public class CartListController {

    private List<CartListDto> cartListDto;

    public CartListController() {
        cartListDto = new ArrayList<>();

        // 더미 데이터
        cartListDto.add(new CartListDto("code1", "1", 2, "goodsCode1"));
        cartListDto.add(new CartListDto("code2", "1", 2, "goodsCode2"));
        cartListDto.add(new CartListDto("code3", "1", 2, "goodsCode3"));
    }

    @GetMapping("")
    public List<CartListDto> getCartList() {
        System.out.println(cartListDto);

        return cartListDto;
    }

    @PostMapping("/addCart")
    public int addCart(String goodsCode, int cartStock) {
        int result = 1;
        cartListDto.add(new CartListDto("code4", "1", cartStock, goodsCode));
        return result;
    }

    @DeleteMapping("/deleteCart")
    public int deleteCart(String cartCode) {
        int result = 1;
        return result;
    }

    @DeleteMapping("/deleteCartList")
    public int deleteCartList(List<String> cartCode) {
        int result = 1;
        return result;
    }

    @PutMapping("/changeStock")
    public int changeStock(CartListDto cartListDto) {
        int result = 1;
        return result;
    }
}
