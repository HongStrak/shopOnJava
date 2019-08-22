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
	private RedisTemplate redisTemplate;
	@Autowired
	private IShoppingCartService shoppingCartService; 
	
	@GetMapping("/map")
	@ResponseBody
	public void test() {
		
		List<ShoppingCart> list = shoppingCartService.selectShoppingCartByUid(1);
		for (ShoppingCart shoppingCart : list) {
			String uid = shoppingCart.getUid().toString();
			OrderForm order = new OrderForm();
			order.setShoppingCart(shoppingCart);
			//2、生成订单号
			String key = System.currentTimeMillis()+"";
			order.setOrderId(key);
			//3、将订单存入数据库
			redisTemplate.opsForHash().put(uid,key,order);	
			//4、生成定时订单 diskey 通过diskey监测订单是否超时
			String diskey = System.currentTimeMillis()+"_"+uid;
			redisTemplate.opsForValue().set(diskey, uid, 30L,TimeUnit.MINUTES);
		}
		
		/*Map map = redisTemplate.opsForHash().entries("1");
		System.out.println(map);*/
		//Set keys2 = 	redisTemplate.keys("[0-9]");
		//Set keys = redisTemplate.opsForHash().keys(1);
		//System.out.println(keys);
		
		/*JSONObject json = JSONObject.parseObject(shoppingCart);
		ShoppingCart shopping = JSON.toJavaObject(json,ShoppingCart.class);
		System.out.println(shopping);*/
		
		
		
	}
	
	
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
