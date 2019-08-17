package com.lanqiao.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.Address;
import com.lanqiao.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;

	
	@PostMapping("/address/list")
	@ResponseBody
	private List<Address> selectAddressByUid(Integer uid){
		return userService.selectAddressByUid(uid);
	}
	
	
	@PostMapping("/address/add")
	private void insertAddress(Address address) {
		userService.insertAddress(address);
	}
	
	
}
