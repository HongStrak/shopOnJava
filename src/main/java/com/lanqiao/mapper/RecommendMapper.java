package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.Recommend;


@Mapper
public interface RecommendMapper {
	
	public void insertRecommend(Recommend Recommend);
	
	public List<Commodity> selectRecommendById(Integer uid);

}
