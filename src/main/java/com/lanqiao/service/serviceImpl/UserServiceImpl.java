package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Address;
import com.lanqiao.domain.User;
import com.lanqiao.mapper.UserMapper;
import com.lanqiao.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Address> selectAddressByUid(Integer uid) {
		return userMapper.selectAddressByUid(uid);
	}

	@Override
	public void insertAddress(Address address) {
		userMapper.insertAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		userMapper.updateAddress(address);
	}

	@Override
	public void deleteAddressById(Integer id) {
		userMapper.deleteAddressById(id);
	}

	@Override
	public User selectUserByPhone(String phone) {
		User user = userMapper.selectUserByPhone(phone);
		return user;
	}

	@Override
	public void insertUserByPhone(String phone) {
		userMapper.insertUserByPhone(phone);
		
	}
	
	
	
}
