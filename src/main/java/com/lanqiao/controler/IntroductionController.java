package com.lanqiao.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@CrossOrigin
@RequestMapping("/introduction")
public class IntroductionController {

	private String code;
	
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
	
	
	//创建用户或者登陆
	@GetMapping("/fun02")
	public String fun02(String phone,String mess){
		User user = userservice.selectUserByPhone(phone);
		if(user==null){
			userservice.insertUserByPhone(phone);
			System.out.println("已创建用户");
			fun02(phone,mess);
		}
		if(code.equals(mess)&&mess!=null&&mess!=""){
			System.out.println(code+":::"+mess);
			return "true";
		}
		return "false";
	}
	
	//获取验证码
	@GetMapping("/fun03")
	public String fun03(String phone){
		String code = jayce.randomCode();
		this.code = code;
		System.out.println(code);
		String data = jayce.SendRandomCode(phone,code);
		return data;
	}
	
	@GetMapping("/fun04")  //获取热销的产品
	public List<Commodity> fun04(){
		
		return jayce.HotSell(5);
	}
	
	@PostMapping("/fun05")
	public List<Commodity> fun05(String gname){
		List<Commodity> l = jayce.SearchByName(gname);
		return l;
	}
}
