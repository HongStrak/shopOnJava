
package com.lanqiao.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public String fun02(String phone,String mess,HttpSession session){
		User user = userservice.selectUserByPhone(phone);
		if(user==null){
			userservice.insertUserByPhone(phone);
			System.out.println("已创建用户");
			fun02(phone,mess,session);
		}
		if(code.equals(mess)&&mess!=null&&mess!=""){
			System.out.println(code+":::"+mess);
			session.setAttribute("phone", phone);
			return "true";
		}
		return "false";
	}
	
	//获取验证码
	@GetMapping("/fun03")
	public String fun03(String phone){
		String code = jayce.randomCode();
		this.code = code;
		
		String data = jayce.SendRandomCode(phone,code);
		System.out.println(code);
		return data;
	}
	
	@GetMapping("/fun04")  //获取热销的产品
	public List<Commodity> fun04(){
		
		return jayce.HotSell(5);
	}
	
	@GetMapping("/fun05")
	public List<Commodity> fun05(String gname){
		List<Commodity> l = jayce.SearchByName(gname);
		return l;
	}
	
	@PostMapping("/fun06")
	public String fun06(String phone,HttpSession session){
		session.setAttribute("phone", phone);
		return "sss";
	}
	
	@PostMapping("/fun07")
	public User fun07(HttpSession session){
		String phone = (String) session.getAttribute("phone");
		User u = userservice.selectUserByPhone(phone);
		System.out.println(u.getUsername());
		return u;
	}
	
	
	//返回我可能喜欢的列表
	@PostMapping("/fun08")
	public List<Commodity> fun08(int uid){
		List<Commodity> l = jayce.SearchILike(uid);
		return l;
	}
	
	@PostMapping("/fun09")
	public void fun09(int uid,int gid){
		jayce.browse(uid, gid);
	}

}
