package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.Address;

public interface IUserService {
	
	/**
	 * 	根据用户uid进行查询所有地址信息
	 * @param uid 用户uid
	 * @return uid用户的地址列表
	 */
	public List<Address> selectAddressByUid(Integer uid);
	
	/**
	 * 	新增用户地址信息
	 * @param address 地址信息bean
	 */
	public void insertAddress(Address address);

}
