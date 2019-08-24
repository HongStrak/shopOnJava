package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.Addr;
import com.lanqiao.domain.TbAddress;



public interface IAddrService {
	 public int insert(Addr record);
	 public List<TbAddress> selectAll(Integer uid);
	 public TbAddress selectByPrimaryKey(Integer id);
	 public int updateByPrimaryKey(Addr record);
	 public int deleteByPrimaryKey(Integer id);
	 public void update(Integer uid);
	  public void update1(TbAddress record);
}
