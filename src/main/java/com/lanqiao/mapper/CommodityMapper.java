package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Commodity;

@Mapper
public interface CommodityMapper {
	
	
	public void delectCommodity(Commodity commodity);
	
	public void addCommodity(Integer gid);
	
	List<Commodity> selectCommodity(Commodity commodity);
	
	public void updateCommodity(Integer gid);

}
