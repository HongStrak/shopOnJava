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
	public String fun03(){
		String code = Math.random()*1000+"";
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI7b2J0gT3hh8h", "qZTNdLme41KdD8nXMRswdl1IG0506Z");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18985840617");
        request.putQueryParameter("SignName", "个人云笔记");
        request.putQueryParameter("TemplateCode", "SMS_171853605");
        
        request.putQueryParameter("TemplateParam", "{'code':'123'}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
		return code;
	}
}
