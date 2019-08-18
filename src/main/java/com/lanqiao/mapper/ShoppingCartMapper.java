package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.ShoppingCart;

@Mapper
public interface ShoppingCartMapper {
	
	public void updateShoppingCart(ShoppingCart shoppingCart);
	public void deleteShoppingCart(ShoppingCart shoppingCart);
	public List<ShoppingCart> selectShoppingCartByUid(Integer id);
	
}
