package com.lanqiao.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.lanqiao.domain.Commodity;
import com.lanqiao.service.ICommodityService;

@Controller("/commodity")
public class CommodityController {
	
	@Autowired
	public ICommodityService commodityService;
	
	@PostMapping("/return")
	public void  returnCommodityStock(Commodity commodity) {
		commodityService.returnCommodityStock(commodity);
	}
	
	

}
