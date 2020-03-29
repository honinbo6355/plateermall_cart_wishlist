package com.plateer;

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
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
@RequestMapping("/api/cart")
public class CartListController {

	@Autowired
	private CartListLogic cartListLogic;

    @GetMapping("")
    public List<CartList> getCartList() {
    	String userId = "user1"; // 세션에서 가져오기
    			
    	List<CartList> cartList = cartListLogic.getCartList(userId);
    	System.out.println(cartList);
    	return cartList;
    }

    @PostMapping("")
    public void addCart(@RequestBody CartListDto cartDto) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	cartDto.setUserId(userId);
    	
    	cartListLogic.addCart(cartDto);
    }

    @DeleteMapping("")
    public void deleteCart(@RequestBody CartList cart) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	cart.setUserId(userId);
    	
    	System.out.println("cartList : " + cart);
    	
    	cartListLogic.deleteCart(cart);
    }

    @DeleteMapping("/list")
    public void deleteCartList(@RequestBody List<CartList> cartList) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cartList.size() : " + cartList.size());
    	
    	cartListLogic.deleteCartList(userId, cartList);
    }

    @PutMapping("")
    public void changeQuantity(@RequestBody CartList cart) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cart : " + cart);
    	
    	cart.setUserId(userId);
    	
    	cartListLogic.changeQuantity(cart);
    }
}
