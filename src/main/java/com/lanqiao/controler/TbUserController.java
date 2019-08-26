package com.lanqiao.controler;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lanqiao.domain.TbUser;
import com.lanqiao.service.ITbUserService;
import com.lanqiao.util.LocalUtil;






@Controller  
@RequestMapping("/user")

public class TbUserController {
     @Autowired
     private ITbUserService userservice;
 	@RequestMapping("/login")
 	public String login(TbUser tbuser,Model model,HttpSession session)
 	{
 		TbUser user=userservice.selectByPrimaryKey(tbuser);
 		if(user==null)
 		{
 			model.addAttribute("mess","用户名或密码错误");
 			return "/login.jsp";
 		}
 	
 			
 			else{
 				session.setAttribute("tbuser", user);
 				return "/attr/init.do";
 			}
 					
 		
 	}
 	@RequestMapping("/update")
 	public String update(TbUser user,HttpServletResponse response, HttpSession session)
 	{
 		System.out.println(user.getSex());
 		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
 		TbUser tbuser=(TbUser)session.getAttribute("tbuser");
 		user.setUid(tbuser.getUid());
 		userservice.updateByPrimaryKey(user);
 		
		return "/pages/person.jsp";
 		
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
