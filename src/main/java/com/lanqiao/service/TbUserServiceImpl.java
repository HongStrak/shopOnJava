package com.lanqiao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.TbUser;
import com.lanqiao.mapper.TbUserMapper;

@Service
public class TbUserServiceImpl implements ITbUserService{

	@Autowired
	private TbUserMapper usermapper;

	@Override
	public int insert(TbUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TbUser selectByPrimaryKey(TbUser record) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(TbUser record) {
		// TODO Auto-generated method stub
		return usermapper.updateByPrimaryKey(record);
	}

	@Override
	public TbUser select(TbUser record) {
		// TODO Auto-generated method stub
		return usermapper.select(record);
	}

}
