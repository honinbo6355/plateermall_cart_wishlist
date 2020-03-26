package com.plateer;

import com.plateer.domain.CartList;
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
    public void addCart(@RequestBody CartList cartList) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cartList : " + cartList);
    	
    	cartList.setUserId(userId);
    	
    	cartListLogic.addCart(cartList);
    }

    @DeleteMapping("/{cartCode}")
    public void deleteCart(@PathVariable String cartCode) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cartCode : " + cartCode);
    	
    	cartListLogic.deleteCart(userId, cartCode);
    }

    @DeleteMapping("/list")
    public void deleteCartList(@RequestBody List<String> cartCodeList) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cartCodeList.size() : " + cartCodeList.size());
    	
    	cartListLogic.deleteCartList(userId, cartCodeList);
    }

    @PutMapping("")
    public void changeStock(@RequestBody CartList cartList) {
    	String userId = "user1"; // 세션에서 가져오기
    	
    	System.out.println("cartList : " + cartList);
    	
    	cartList.setUserId(userId);
    	
    	cartListLogic.changeStock(cartList);
    }
}
