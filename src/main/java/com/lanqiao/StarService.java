package com.lanqiao;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.OrderForm;
import com.lanqiao.service.ICommodityService;

@Component
public class StarService implements	ApplicationRunner {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private ICommodityService commodityService; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Set keys = redisTemplate.keys("[0-9]");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (Object uid : keys) {
					Map map = redisTemplate.opsForHash().entries(uid.toString());
					Set orderIds = map.keySet();
					for (Object orderId : orderIds) {
						//1、获取到diskey
						String key = orderId.toString()+"_"+uid;
						//2、查看是否存在这个定时diskey，不存在，则将订单还原
						if(!redisTemplate.hasKey(key)) {
							//4、还原商品库存信息，方法暂时还未实现
							//3、获取到orderForm
							OrderForm order = (OrderForm)redisTemplate.opsForHash().get(uid.toString(), orderId);
							
							commodityService.returnCommodityStock(new Commodity(order.getShoppingCart().getTotal(),
									order.getShoppingCart().getTotal()+order.getShoppingCart().getCommodity().getStock()));
						 
							//3、还原后，并删除订单
							redisTemplate.opsForHash().delete(uid.toString(), orderId);
						}	
					}	
				}
			}
		}).start();
			
		
	
		
	}

}
