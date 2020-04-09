package com.plateer.service.logic;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateer.WishlistDao;
import com.plateer.domain.Wishlist;
import com.plateer.logic.WishlistDaoImpl;
import com.plateer.service.WishlistService;

@Service
public class WishlistLogic implements WishlistService {

	private WishlistDao wishlistDao;
	
	public WishlistLogic(WishlistDaoImpl wishlistDaoImpl) {
		this.wishlistDao = wishlistDaoImpl;
	}
	
	@Override
	public void addWishList(List<Wishlist> wishList) {
		wishlistDao.saveWishList(wishList);
	}

	@Override
	public void addWish(Wishlist wish) {
		wish.setWishCode(UUID.randomUUID().toString());
		wishlistDao.saveWish(wish);
	}

	public List<String> getGoodsCodes(String userId) {
		return wishlistDao.findGoodsCodes(userId);
	}

	public void deleteGoodsWish(String goodsCode) {
		wishlistDao.removeGoodsWish(goodsCode);
	}
}
