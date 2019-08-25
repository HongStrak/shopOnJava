package com.lanqiao.service;

import org.springframework.stereotype.Service;

import com.lanqiao.domain.TbUser;



public interface ITbUserService {
	 public TbUser select(TbUser record);
	 public int insert(TbUser record);
	 public TbUser selectByPrimaryKey(TbUser record);
	 public int updateByPrimaryKey(TbUser record);
}
