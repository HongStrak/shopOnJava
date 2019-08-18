package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.Commodity;

public interface ICommodityService {
	
	public void delectCommodity(Commodity commodity);
	
	public void addCommodity(Integer gid);
	
	List<Commodity> selectCommodity(Commodity commodity);
	
	public void updateCommodity(Integer gid);
}
