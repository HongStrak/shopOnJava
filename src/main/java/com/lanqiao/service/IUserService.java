package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.Address;
import com.lanqiao.domain.User;

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
	
	/**
	 * 	根据地址id修改用户地址信息
	 * @param id 地址id
	 */
	public void updateAddress(Address address);
	
	/**
	 * 	根据地址id删除地址
	 * @param id 地址id
	 */
	public void deleteAddressById(Integer id);
	
	
	public User selectUserByPhone(String phone);
	
	public void insertUserByPhone(String phone);

}
