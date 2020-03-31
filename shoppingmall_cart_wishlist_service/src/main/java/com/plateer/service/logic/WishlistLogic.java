package com.plateer.service.logic;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.domain.Wishlist;
import com.plateer.logic.WishlistDaoImpl;
import com.plateer.service.WishlistService;

@Service
public class WishlistLogic implements WishlistService {

	@Autowired
	private WishlistDaoImpl wishlistDaoImpl;
	
	@Override
	public void addWishList(String userId, List<Wishlist> wishList) {
		wishlistDaoImpl.saveWishList(userId, wishList);
	}

	@Override
	public void addWish(Wishlist wish) {
		wish.setWishCode(UUID.randomUUID().toString());
		wishlistDaoImpl.saveWish(wish);
	}

	public List<String> getGoodsCodes(String userId) {
		return wishlistDaoImpl.findGoodsCodes(userId);
	}

	public void deleteGoodsWish(String goodsCode) {
		wishlistDaoImpl.removeGoodsWish(goodsCode);
	}
}
