package com.plateer.service;

import java.util.List;
import java.util.Map;

import com.plateer.domain.Wishlist;

public interface WishlistService {
	
	void addWishList(String userId, List<Wishlist> wishList);
	void addWish(Wishlist wish);
	List<String> getGoodsCodes(String userId);
	void deleteGoodsWish(String goodsCode);
}
