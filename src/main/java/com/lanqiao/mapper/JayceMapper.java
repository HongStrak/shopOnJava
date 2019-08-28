package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Commodity;

@Mapper
public interface JayceMapper {

	public List<Commodity> HotSell(Integer num);
	
	public List<Commodity> SearchByName(String gname);
	
	public int[] SearchILike(int uid);
	
	public List<Commodity> SearchSameCom(int tid);
}
