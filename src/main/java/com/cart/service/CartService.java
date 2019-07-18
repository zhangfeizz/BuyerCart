package com.cart.service;

import com.cart.buyer.BuyerCart;
import com.cart.pojo.Sku;

public interface CartService {

	void insertBuyerCartToRedis(BuyerCart buyerCart, String username);

	BuyerCart selectBuyerCartFromRedis(String username);

	Sku selectSkuById(Long id);

	BuyerCart selectBuyerCartFromRedisBySkuIds(String[] skuIds, String username);

}
