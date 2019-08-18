package com.lanqiao.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.service.IShoppingCartService;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@Autowired
	private IShoppingCartService shoppingCartService;
	
	@PostMapping("/shopping/update")
	public void update(ShoppingCart shoppingCart){
		shoppingCartService.updateShoppingCart(shoppingCart);;
	}
	
	@PostMapping("/shopping/delete")
	public void delete(ShoppingCart shoppingCart){
		shoppingCartService.deleteShoppingCart(shoppingCart);
	}

}
