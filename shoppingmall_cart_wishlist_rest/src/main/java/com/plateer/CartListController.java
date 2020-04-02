package com.plateer;

import com.plateer.domain.CardDiscountInfo;
import com.plateer.domain.CartList;
import com.plateer.dto.CartListDto;
import com.plateer.service.CartListService;
import com.plateer.service.logic.CartListLogic;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Slf4j
@RestController
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie", "Authorization"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
@RequestMapping("/api/cart")
public class CartListController {

	@Autowired
	private CartListLogic cartListLogic;

    @GetMapping("{userId}")
    public List<CartList> getCartList(@PathVariable("userId") String userId) {
    	List<CartList> cartList = cartListLogic.getCartList(userId);
    	System.out.println(cartList);
    	return cartList;
    }

    @PostMapping("")
    public void addCart(@RequestBody CartListDto cartDto) {
    	cartListLogic.addCart(cartDto);
    }

    @DeleteMapping("")
    public void deleteCart(@RequestBody CartList cart) {
    	cartListLogic.deleteCart(cart);
    }

    @DeleteMapping("/list")
    public void deleteCartList(@RequestBody List<CartList> cartList) {
    	cartListLogic.deleteCartList(cartList);
    }

    @PutMapping("")
    public void changeQuantity(@RequestBody CartList cart) {
    	cartListLogic.changeQuantity(cart);
    }
    
    @GetMapping("/cardInfo")
    public List<CardDiscountInfo> getCardDiscountInfo() {
    	return cartListLogic.getCardDiscountInfo();
    }
}
