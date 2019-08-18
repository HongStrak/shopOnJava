package com.lanqiao.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lanqiao.service.ICommodityService;

@Controller
public class CommodityController {
	
	@Autowired
	private ICommodityService commodityService;
	
	
	public void add(){
		
	}

}
