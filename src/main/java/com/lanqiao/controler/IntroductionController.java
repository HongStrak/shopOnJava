package com.lanqiao.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.User;
import com.lanqiao.mapper.CommodityMapper;
import com.lanqiao.service.IUserService;
import com.lanqiao.service.serviceImpl.Ijayce;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
@RestController
@CrossOrigin
@RequestMapping("/introduction")
public class IntroductionController {

	@Autowired
	private CommodityMapper commoditys;
	
	@Autowired
	private IUserService userservice;
	
	@Autowired
	private Ijayce jayce;
	@GetMapping("/upload")
	public Commodity fun01(int gid){
		Commodity cm = new Commodity();
		cm.setGid(3);
		return  commoditys.selectCommodityById(gid);
	}
	
	
	//创建用户
	@GetMapping("/fun02")
	public User fun02(String phone){
		User user = userservice.selectUserByPhone(phone);
		if(user==null){
			userservice.insertUserByPhone(phone);
			System.out.println("已创建用户");
			fun02(phone);
		}
		return user;
	}
	
	//获取验证码
	@GetMapping("/fun03")
	public String fun03(String phone){
		String code = jayce.SendRandomCode(phone);
		return code;
	}
}
