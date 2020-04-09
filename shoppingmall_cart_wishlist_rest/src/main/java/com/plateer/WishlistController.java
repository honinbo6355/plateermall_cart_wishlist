package com.plateer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.domain.Wishlist;
import com.plateer.service.WishlistService;
import com.plateer.service.logic.WishlistLogic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(allowCredentials = "true", origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},
        allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "Set-Cookie", "Authorization"},
        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"}, maxAge = 3000)
@RequestMapping("/api/wishlist")
public class WishlistController {

	private WishlistService wishlistService;
	
	public WishlistController(WishlistLogic wishlistLogic) {
		this.wishlistService = wishlistLogic;
	}
	
	@PostMapping("")
	public void addGoods(@RequestBody Wishlist wish) {
		System.out.println("wish : " + wish);
		
		wishlistService.addWish(wish);
	}
	
	@PostMapping("/list")
	public void addGoodsList(@RequestBody List<Wishlist> wishList) {
		System.out.println("wishList : " + wishList);
		
		wishlistService.addWishList(wishList);
	}
	
	@GetMapping("{userId}")
	public List<String> getGoodsCodes(@PathVariable("userId") String userId) {
		System.out.println("userId : " + userId);
		
		List<String> goodsCodes = wishlistService.getGoodsCodes(userId);
		
		System.out.println("goodsCodes : " + goodsCodes);
		
		return goodsCodes;
	}
	
	@DeleteMapping("{goodsCode}")
	public void deleteGoodsWish(@PathVariable("goodsCode") String goodsCode) {
		System.out.println(goodsCode);
		
		wishlistService.deleteGoodsWish(goodsCode);
	}
}
