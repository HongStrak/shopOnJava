package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Commodity;
import com.lanqiao.mapper.CommodityMapper;
import com.lanqiao.service.ICommodityService;

@Service
public class CommodityServiceImpl implements ICommodityService{
	
	@Autowired
	private CommodityMapper commodityMapper;

	@Override
	public void delectCommodity(Commodity commodity) {
		commodityMapper.delectCommodity(commodity);
		
	}

	@Override
	public void addCommodity(Integer gid) {
		commodityMapper.addCommodity(gid);
		
	}

	@Override
	public List<Commodity> selectCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityMapper.selectCommodity(commodity);
	}

	@Override
	public void updateCommodity(Integer gid) {
		commodityMapper.updateCommodity(gid);
		
	}

	


	

}
