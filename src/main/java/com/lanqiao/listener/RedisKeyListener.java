package com.lanqiao.listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.OrderForm;
import com.lanqiao.service.ICommodityService;

public class RedisKeyListener implements MessageListener{

	@Autowired 
	private StringRedisTemplate stringRedisTemplate; 
	
	@Autowired
	private RedisTemplate redisTemplate;
		
	@Autowired
	private ICommodityService commodityService; 
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println("diskey:"+message);
		//1、获取到要消亡的key值
		String diskey = message.toString();
		//System.out.println(diskey);
		//2、找到与之关联的key
		String[] split = diskey.split("_");
		String key = split[0];
		String uid = split[1];
		//3、获取到orderForm
		OrderForm order = (OrderForm)redisTemplate.opsForHash().get(uid, key);
		
		//4、还原商品库存信息，方法暂时还未实现
		commodityService.returnCommodityStock(new Commodity(order.getShoppingCart().getTotal(),
				order.getShoppingCart().getTotal()+order.getShoppingCart().getCommodity().getStock()));
	 
		
		//5、删除redis数据库数据
		redisTemplate.opsForHash().delete(uid, key);

	}

}