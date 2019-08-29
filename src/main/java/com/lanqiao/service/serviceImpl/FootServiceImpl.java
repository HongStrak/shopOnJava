package com.lanqiao.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Foot;
import com.lanqiao.mapper.FootMapper;
import com.lanqiao.service.IFootService;

@Service
  public class FootServiceImpl implements IFootService{
	
	@Autowired
	private FootMapper footMapper;
	



	@Override
	public void deleteFoot(Foot foot) {
		footMapper.deleteFoot(foot);
		
	}

	@Override
	public void insertFoot(Foot foot) {
		footMapper.insertFoot(foot);
		
	}

	@Override
	public List<Map> selectFootByGdate(Foot foot) {
		// TODO Auto-generated method stub
		return footMapper.selectFootByGdate(foot);
	}

	@Override
	public List<Foot> selectFootByUid(Foot foot) {
		// TODO Auto-generated method stub
		return footMapper.selectFootByUid(foot);
	}



	

}
