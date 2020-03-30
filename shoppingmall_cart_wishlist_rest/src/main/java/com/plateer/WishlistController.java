package com.plateer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.domain.Wishlist;
import com.plateer.service.logic.WishlistLogic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
@RequestMapping("/api/wishlist")
public class WishlistController {

	@Autowired
	private WishlistLogic wishlistLogic;
	
	@PostMapping("")
	public void addGoods(@RequestBody Wishlist wish) {
		String userId = "user1"; // 세션에서 가져오기
		
		System.out.println("wish : " + wish);
		
		wish.setUserId(userId);
		
		wishlistLogic.addWish(wish);
	}
	
	@PostMapping("/list")
	public void addGoodsList(@RequestBody List<Wishlist> wishList) {
		String userId = "user1"; // 세션에서 가져오기
		
		System.out.println("wishList : " + wishList);
		
		wishlistLogic.addWishList(userId, wishList);
	}
	
	@GetMapping("")
	public List<String> getGoodsCodes() {
		String userId = "user1"; // 세션에서 가져오기
		
		List<String> goodsCodes = wishlistLogic.getGoodsCodes(userId);
		
		System.out.println("goodsCodes : " + goodsCodes);
		
		return goodsCodes;
	}
}
