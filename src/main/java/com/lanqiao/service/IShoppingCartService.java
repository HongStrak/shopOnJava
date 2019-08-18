package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.ShoppingCart;

public interface IShoppingCartService {
	
	public void updateShoppingCart(ShoppingCart shoppingCart);
	public void deleteShoppingCart(ShoppingCart shoppingCart);
	public List<ShoppingCart> selectShoppingCartByUid(Integer id);
}
