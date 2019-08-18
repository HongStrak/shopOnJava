package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.ShoppingCart;

public interface IShoppingCartService {
	/**
	 * 	根据gid及uid修改ShoppingCart购买商品的数量
	 * @param shoppingCart 封装有gid及uid
	 */
	public void updateShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * 	根据gid及uid删除对应的购物车数量
	 * @param shoppingCart 封装有gid及uid
	 */
	public void deleteShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * 	根据uid来进行查询用户购物车的商品信息
	 * @param uid 用户id
	 * @return 用户商品信息
	 */
	public List<ShoppingCart> selectShoppingCartByUid(Integer uid);
	
	/**
	 * 	插入一个新的购物情况
	 * @param shoppingCart 购物情况对象(uid,gid,total)
	 */
	public void insertShoppingCart(ShoppingCart shoppingCart);
}
