package com.lanqiao.service;

import java.util.List;
import java.util.Map;

import com.lanqiao.domain.Foot;

public interface IFootService {
	
	
	public List<Foot> selectFootByUid(Foot foot);
	
	public void deleteFoot(Foot foot);
	
	public void insertFoot(Foot foot);
	
	public List<Map> selectFootByGdate(Foot foot);

}
