package com.lanqiao;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class StarService implements	ApplicationRunner {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Set keys = redisTemplate.keys("[0-9]");
		for (Object uid : keys) {
			Map map = redisTemplate.opsForHash().entries(uid);
			Set orderIds = map.keySet();
			for (Object orderId : orderIds) {
				System.out.println(orderId);
			}	
		}
		
		/*
		for (Object uid : keys) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Map map = redisTemplate.opsForHash().entries(uid);
					Set orderIds = map.keySet();
					for (Object orderId : orderIds) {
						//1、获取到diskey
						String key = uid + orderId.toString();
						//2、查看是否存在这个定时diskey，不存在，则将订单还原
						if(!redisTemplate.hasKey(key)) {
	
							//  还原商品库存信息，方法暂时还未实现
							//commondityService.updateCommondityStock();
	
							//3、还原后，并删除订单
							redisTemplate.opsForHash().delete(uid, orderId);
						}
						
					}	
					
				}
			}).start();
			
		}
		*/
	
		
	}

}
