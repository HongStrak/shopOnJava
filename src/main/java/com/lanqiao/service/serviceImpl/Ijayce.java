package com.lanqiao.service.serviceImpl;

import java.util.List;

import com.lanqiao.domain.Commodity;

public interface Ijayce {
	public String SendRandomCode(String phone,String code);
	
	
	public String randomCode();
	
	//热销
	public List<Commodity> HotSell(int num);
}
