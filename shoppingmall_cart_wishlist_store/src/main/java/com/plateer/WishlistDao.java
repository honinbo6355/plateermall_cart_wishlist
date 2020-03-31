package com.plateer;

import java.util.List;

import com.plateer.domain.Wishlist;

public interface WishlistDao {
	void saveWishList(String userId, List<Wishlist> wishList);
	void saveWish(Wishlist wish);
	List<String> findGoodsCodes(String userId);
	void removeGoodsWish(String goodsCode);
}
