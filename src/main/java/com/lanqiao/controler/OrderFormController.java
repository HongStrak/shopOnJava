package com.lanqiao.controler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanqiao.domain.OrderForm;
import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.service.IOrderFormService;
import com.lanqiao.service.IShoppingCartService;

@Controller
@RequestMapping("/order")
public class OrderFormController {
	
	@Autowired
	private IOrderFormService orderFormService; 

	@Autowired
	private IShoppingCartService shoppingCartService; 
	
	
	@PostMapping("/select")
	@ResponseBody
	public Map selectOrderFromByUid(Integer uid) {
		return orderFormService.selectOrderFromByUid(uid);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public void createOrderFrom(@RequestParam String shoppingCart) {
		JSONObject json = JSONObject.parseObject(shoppingCart);
		ShoppingCart shopping = JSON.toJavaObject(json,ShoppingCart.class);
		orderFormService.createOrderFrom(shopping);
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public void cancelOrderForm(Integer uid,String orderId) {
		orderFormService.cancelOrderForm(uid, orderId);
	}
	
	@PostMapping("/commit")
	@ResponseBody
	public void commitOrderForm(@RequestParam String orderForm) {
		JSONObject json = JSONObject.parseObject(orderForm);
		OrderForm order = JSON.toJavaObject(json,OrderForm.class);
		orderFormService.commitOrderForm(order);
	}
	
}
