package com.lanqiao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Foot;

@Mapper
public interface FootMapper {
	
	public List<Foot> selectFootByUid(Foot foot);
	
	public void deleteFoot(Foot foot);
	
	public void insertFoot(Foot foot);
	
	public List<Map> selectFootByGdate(Foot foot);


}
