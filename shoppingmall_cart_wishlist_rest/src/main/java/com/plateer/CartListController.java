package com.plateer;

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
    public List<CartListDto> getCartList() {
    	List<CartListDto> cartListDto = cartListLogic.getCartList();
    	System.out.println(cartListDto);
    	return cartListDto;
    }

    @PostMapping("")
    public void addCart(@RequestBody CartListDto cartListDto) {
        
    }

    @DeleteMapping("/{cartCode}")
    public void deleteCart(@PathVariable String cartCode) {
    	System.out.println("cartCode : " + cartCode);
    	
    	cartListLogic.deleteCart(cartCode);
    }

    @DeleteMapping("/list")
    public void deleteCartList(@RequestBody List<String> cartCodeList) {
    	System.out.println("cartCodeList.size() : " + cartCodeList.size());
    	
    	cartListLogic.deleteCartList(cartCodeList);
    }

    @PutMapping("")
    public int changeStock(CartListDto cartListDto) {
        int result = 1;
        return result;
    }
}
