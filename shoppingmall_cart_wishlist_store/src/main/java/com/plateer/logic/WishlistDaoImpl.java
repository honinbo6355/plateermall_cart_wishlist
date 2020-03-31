package com.plateer.logic;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plateer.WishlistDao;
import com.plateer.domain.Wishlist;
import com.plateer.mapper.WishlistMapper;

@Repository
public class WishlistDaoImpl implements WishlistDao {

	@Autowired
	private WishlistMapper wishlistMapper;
	
	@Override
	public void saveWishList(String userId, List<Wishlist> wishList) {
		for (Wishlist wish : wishList) {
			wish.setWishCode(UUID.randomUUID().toString());
			wish.setUserId(userId);
			
			wishlistMapper.saveWish(wish);
		}
	}

	@Override
	public void saveWish(Wishlist wish) {
		wishlistMapper.saveWish(wish);
	}

	public List<String> findGoodsCodes(String userId) {
		return wishlistMapper.findGoodsCodes(userId);
	}

	public void removeGoodsWish(String goodsCode) {
		wishlistMapper.removeGoodsWish(goodsCode);
	}
}
