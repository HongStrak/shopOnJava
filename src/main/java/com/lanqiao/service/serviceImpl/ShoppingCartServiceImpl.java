package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.mapper.ShoppingCartMapper;
import com.lanqiao.service.IShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper ;

	@Override
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartMapper.updateShoppingCart(shoppingCart);
	}

	@Override
	public void deleteShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartMapper.deleteShoppingCart(shoppingCart);
	}

	@Override
	public List<ShoppingCart> selectShoppingCartByUid(Integer id) {
		return shoppingCartMapper.selectShoppingCartByUid(id);
	}

	

}
