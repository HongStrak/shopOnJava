package com.lanqiao.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.service.IShoppingCartService;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
	
	@Autowired
	private IShoppingCartService shoppingCartService;
	
	@PostMapping("/update")
	public void updateShoppingCart(ShoppingCart shoppingCart){
		shoppingCartService.updateShoppingCart(shoppingCart);;
	}
	
	@PostMapping("/delete")
	public void deleteShoppingCart(ShoppingCart shoppingCart){
		shoppingCartService.deleteShoppingCart(shoppingCart);
	}
	
	@PostMapping("/select")
	@ResponseBody
	public void selectShoppingCartByUid(Integer uid){
		shoppingCartService.selectShoppingCartByUid(uid);
	}
}
