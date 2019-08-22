package com.lanqiao.controler;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.OrderForm;
import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.service.IShoppingCartService;

@Controller
@RequestMapping("order")
public class OrderFormController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired 
	private StringRedisTemplate stringRedisTemplate; 
	 
	@Autowired
	private IShoppingCartService shoppingCartService; 
	
	@PostMapping("/map")
	@ResponseBody
	public void test(@RequestBody final Map maps) {
		//List<ShoppingCart> list = shoppingCartService.selectShoppingCartByUid(1);
		/*for (ShoppingCart shoppingCart : list) {
			Integer uid = shoppingCart.getUid();
			OrderForm order = new OrderForm();
			order.setShoppingCart(shoppingCart);
			//2、生成订单号
			String key = System.currentTimeMillis()+"";
			order.setOrderId(key);
			//3、将订单存入数据库
			redisTemplate.opsForHash().put(uid.toString(),key,order);	
			//4、生成定时订单 diskey 通过diskey监测订单是否超时
			String diskey = System.currentTimeMillis()+"_"+uid;
			redisTemplate.opsForValue().set(diskey, uid, 30L,TimeUnit.MINUTES);
		}*/
		
		//redisTemplate.opsForValue().set("1234_AB", "测试", 10L,TimeUnit.SECONDS);
	
		//Set keys2 = 	redisTemplate.keys("[0-9]");
		//Set keys = redisTemplate.opsForHash().keys(1);
		//System.out.println(keys);
		System.out.println(maps);
		
	}
	
	
	@PostMapping("/select")
	@ResponseBody
	public Map selectOrderFromByUid(Integer uid) {
		Map maps = redisTemplate.opsForHash().entries(uid);	
		return maps;
	}
	
	@PostMapping("/create")
	@ResponseBody
	public void createOrderFrom(ShoppingCart shoppingCart) {
		//1、创建订单
		Integer uid = shoppingCart.getUid();
		OrderForm order = new OrderForm();
		order.setShoppingCart(shoppingCart);
		//2、生成订单号
		String key = System.currentTimeMillis()+"";
		order.setOrderId(key);
		//3、将订单存入数据库
		redisTemplate.opsForHash().put(uid,key,order);	
		//4、生成定时订单 diskey 通过diskey监测订单是否超时
		String diskey = System.currentTimeMillis()+"_"+uid;
		//5、将diskey存入redis
		redisTemplate.opsForValue().set(diskey, uid, 30L,TimeUnit.MINUTES);
	}
	
	@PostMapping("/cancel")
	@ResponseBody
	public void cancelOrderForm(Integer uid,String orderId) {
		//1、获取到要删除的订单
		OrderForm order = (OrderForm)redisTemplate.opsForHash().get(uid, orderId);
		
		//2、还原mysql数据库中,商品的库存
		Integer total = order.getShoppingCart().getTotal();
		Integer gid = order.getShoppingCart().getGid();
		
		/*
		 * 还原商品库存信息，方法暂时还未实现
		 * commondityService.updateCommondityStock();
		 */
		
		//3、删除redis数据库中的信息
		redisTemplate.opsForHash().delete(uid, orderId);
	}
	
	@PostMapping("/commit")
	@ResponseBody
	public void commitOrderForm(OrderForm orderForm) {
		//1、删除定时任务，避免数据重新返回库存
		String orderId = orderForm.getOrderId();
		String diskey = orderId + orderForm.getShoppingCart().getUid();
		redisTemplate.delete(diskey);
		//2、生成结算信息，存入mysql，或者redis（看情况出理）
		
		/*带处理事务*/
		
		//3、更新redis
		redisTemplate.opsForHash().delete(orderForm.getShoppingCart().getUid(),orderId);
	}
	
	
	
}
