package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Address;

@Mapper
public interface UserMapper {
	
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
