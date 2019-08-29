package com.lanqiao.controler;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lanqiao.domain.TbUser;
import com.lanqiao.mapper.TbUserMapper;
import com.lanqiao.service.ITbUserService;
import com.lanqiao.util.LocalUtil;


@RestController
@RequestMapping("/user")
public class TbUserController {
     @Autowired
     private ITbUserService userservice;
     
     @Autowired
     private TbUserMapper tbuserMapper;
 	/*@RequestMapping("/login")
 	public TbUser login()
 	{
 		TbUser user=new TbUser();
 		user.setUsername("faker");
 		user.setPassword("123456");
 		return userservice.selectByPrimaryKey(tbuser);
 	}*/
 	
 	@PostMapping("/selectm")
 	public TbUser selectM(){
 		TbUser user=new TbUser();
 		user.setUsername("faker");
 		user.setPassword("123456");
 		System.out.println(user);
 		return tbuserMapper.selectByPrimaryKey(user);
 	}
 	
 	
 	@PostMapping("/update")
 	public String update(TbUser user,HttpServletResponse response, HttpSession session)
 	{
 		System.out.println(user.getSex());
 		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
 		
 		
 		userservice.updateByPrimaryKey(user);
 		
		return "success";
 		
 	}
    @RequestMapping("/province")
    public String provinces(HttpServletRequest request,Model model){
    	
     LocalUtil lu =  LocalUtil.getInstance();
     
     List<String> sheng = lu.getProvinces("中国");
     //存储中国所有的省份
     model.addAttribute("province",sheng);
     return "/pages/editAddr.jsp";
   

    }
    @ResponseBody
    @RequestMapping("/city")
    public List<String> cities(HttpServletRequest request,String sel1,Model model) throws UnsupportedEncodingException
    {
    	
      System.out.println(sel1);
        
       LocalUtil lu =  LocalUtil.getInstance();
       List<String>  shi = lu.getCitie(sel1);
       System.out.println(shi.size());
		return shi;
    	
    }
    @ResponseBody
    @RequestMapping("/xian")
    public List<String> cities(String sel1,String sel2)
    {
    
    	  System.out.println(sel1);
    	  System.out.println(sel2);
       LocalUtil lu =  LocalUtil.getInstance();
   
   
       List<String>  countyName = lu.getxian(sel1,sel2);
       System.out.println(countyName.size());
		return countyName;
    	
    }
  


 




	
}
