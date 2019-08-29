package com.lanqiao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lanqiao.domain.TbUser;



public interface ITbUserService {
	
	
	int deleteByPrimaryKey(Integer uid);

    int insert(TbUser record);

    public TbUser selectByPrimaryKey(TbUser tbuser);
    
    public TbUser select(TbUser record);

    List<TbUser> selectAll();

    public int updateByPrimaryKey(TbUser record);
}
