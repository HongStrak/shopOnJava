package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.TbUser;
import com.lanqiao.mapper.TbUserMapper;
import com.lanqiao.service.ITbUserService;

@Service
public class TbUserServiceImpl implements ITbUserService{
	
	@Autowired
	private TbUserMapper tbUserMapper;
	

	@Override
	public TbUser select(TbUser record) {
		// TODO Auto-generated method stub
		return tbUserMapper.select(record);
	}

	@Override
	public int insert(TbUser record) {
		// TODO Auto-generated method stub
		return tbUserMapper.insert(record);
		
	}

	

	@Override
	public int updateByPrimaryKey(TbUser record) {
		// TODO Auto-generated method stub
		return tbUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return tbUserMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public TbUser selectByPrimaryKey(TbUser tbuser) {
		// TODO Auto-generated method stub
		return tbUserMapper.selectByPrimaryKey(tbuser);
	}

	@Override
	public List<TbUser> selectAll() {
		// TODO Auto-generated method stub
		return tbUserMapper.selectAll();
	}

}
