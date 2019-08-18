package com.lanqiao.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanqiao.domain.Commodity;
import com.lanqiao.mapper.CommodityMapper;

@RestController
@CrossOrigin
@RequestMapping("/introduction")
public class IntroductionController {

	@Autowired
	private CommodityMapper commoditys;
	
	
	@GetMapping("/upload")
	public Commodity test01(int gid){
		
		Commodity cm = new Commodity();
		cm.setGid(3);
		
		return  commoditys.selectCommodityById(gid);
	}
}
