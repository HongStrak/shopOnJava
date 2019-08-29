package com.lanqiao.service.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.OrderForm;
import com.lanqiao.domain.ShoppingCart;
import com.lanqiao.service.ICommodityService;
import com.lanqiao.service.IOrderFormService;
import com.lanqiao.service.IShoppingCartService;

@Service
@SuppressWarnings("all")
public class OrderFormServiceImpl implements IOrderFormService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired 
	private StringRedisTemplate stringRedisTemplate; 
	 
	@Autowired
	private IShoppingCartService shoppingCartService; 
	
	@Autowired
	private ICommodityService commodityService; 
	
	
	public Map selectOrderFromByUid(Integer uid) {
		Map maps = redisTemplate.opsForHash().entries(uid.toString());	
		return maps;
	}
	
	public void createOrderFrom(List<ShoppingCart> shoppingCarts) {
		for (ShoppingCart shoppingCart : shoppingCarts) {
			//1、创建订单
			String uid = shoppingCart.getUid().toString();
			OrderForm order = new OrderForm();
			order.setShoppingCart(shoppingCart);
			//2、生成订单号
			String key = System.currentTimeMillis()+"";
			order.setOrderId(key);
			//3、将订单存入数据库
			redisTemplate.opsForHash().put(uid,key,order);	
			//4、生成定时订单 diskey 通过diskey监测订单是否超时
			String diskey = key+"_"+uid;
			//5、将diskey存入redis
			redisTemplate.opsForValue().set(diskey, uid, 30L,TimeUnit.MINUTES);
			//6、删除购物车
			shoppingCartService.deleteShoppingCart(shoppingCart);
			//7、生成订单，减少库存
			commodityService.returnCommodityStock(new Commodity(shoppingCart.getTotal(),
					shoppingCart.getCommodity().getStock()-shoppingCart.getTotal()));
			 
		}
	}

	public void cancelOrderForm(Integer uid,String orderId) {
		String _uid = uid.toString();
		//1、获取到要删除的订单
		OrderForm order = (OrderForm)redisTemplate.opsForHash().get(_uid, orderId);
		
		//2、还原mysql数据库中,商品的库存
		Integer total = order.getShoppingCart().getTotal();
		Integer gid = order.getShoppingCart().getGid();
		
		
		//还原商品库存信息
		commodityService.returnCommodityStock(new Commodity(order.getShoppingCart().getTotal(),
					order.getShoppingCart().getTotal()+order.getShoppingCart().getCommodity().getStock()));
		 
		
		//3、删除redis数据库中的信息
		redisTemplate.opsForHash().delete(_uid, orderId);
	}
	

	public void commitOrderForm(OrderForm orderForm) {
		//1、删除定时任务，避免数据重新返回库存
		String orderId = orderForm.getOrderId();
		String diskey = orderId +"_" + orderForm.getShoppingCart().getUid();
		redisTemplate.delete(diskey);
		//2、生成结算信息，存入mysql，或者redis（看情况出理）
		
		/*带处理事务*/
		
		//3、更新redis
		
		redisTemplate.opsForHash().delete(orderForm.getShoppingCart().getUid().toString(),orderId);
	
	}
}
