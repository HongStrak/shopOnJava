package com.lanqiao.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lanqiao.domain.Addr;
import com.lanqiao.domain.TbAddress;
import com.lanqiao.domain.TbUser;
import com.lanqiao.service.IAddrService;
import com.lanqiao.util.LocalUtil;


@Controller
@RequestMapping("/addr")
public class AddrController {
	@Autowired
	private IAddrService addrservice;
	@RequestMapping("/addradd")
	public String addradd(Addr addr,HttpSession session)
	{
		TbUser tbuser=(TbUser)session.getAttribute("tbuser");
		
		String sheng=addr.getSheng();
		String shi=addr.getShi();
		if(sheng!=null)
		{
		if((sheng.equals("北京")||sheng.equals("上海")||sheng.equals("重庆")||sheng.equals("天津")))
		{
			sheng=sheng+"市";
			if(shi!=null)
			{
			shi=shi+"区";
			}
		}
		else
		{
			sheng=sheng+"省";
			if(shi!=null)
			{
				shi=shi+"市";
			}
			
		}
		}
		
		String xian=addr.getXian();
		String detail=addr.getDetail();
		String address=sheng+shi+detail;
		if(xian!=null)
		{
		address=address+xian;
		}
		addr.setUid(tbuser.getUid());
		addr.setAddress(address);
		addrservice.insert(addr);
		return "/pages/person.jsp";
		
	}
	@RequestMapping("/select")
	public String select(HttpSession session,Model model)
	{
		TbUser user=(TbUser)session.getAttribute("tbuser");
		Integer id=user.getUid();
		List<TbAddress> addr=addrservice.selectAll(id);
		model.addAttribute("addr",addr);
		return "/addr/province.do";
	}
	@RequestMapping("/toupdate")
	public String toupdate(@RequestParam("id") Integer id,Model model)
	{
		TbAddress address= addrservice.selectByPrimaryKey(id);
		model.addAttribute("address",address);
		model.addAttribute("id",id);
		return "/user/province.do";
	}
	@RequestMapping("/update")
	public String update(@RequestParam("id") Integer id,HttpSession session,  Addr addr){
		addr.setId(id);
		TbUser user=(TbUser)session.getAttribute("tbuser");
		String sheng=addr.getSheng();
		String shi=addr.getShi();
		if(sheng!=null)
		{
		if((sheng.equals("北京")||sheng.equals("上海")||sheng.equals("重庆")||sheng.equals("天津")))
		{
			sheng=sheng+"市";
			if(shi!=null)
			{
			shi=shi+"区";
			}
		}
		else
		{
			sheng=sheng+"省";
			if(shi!=null)
			{
				shi=shi+"市";
			}
			
		}
		}
		
		String xian=addr.getXian();
		String detail=addr.getDetail();
		String address=null;
		if(xian!=null)
		{
		address=sheng+shi+xian+detail;
		}
		addr.setAddress(address);
		addr.setUid(user.getUid());
		addrservice.updateByPrimaryKey(addr);
		return "/addr/select.do";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Integer id)
	{
		addrservice.deleteByPrimaryKey(id);
		return "/addr/select.do";
		
	}
	  @RequestMapping("/province")
	    public String provinces(HttpServletRequest request,Model model){
	    	
	     LocalUtil lu =  LocalUtil.getInstance();
	     
	     List<String> sheng = lu.getProvinces("中国");
	     //存储中国所有的省份
	     model.addAttribute("province",sheng);
	     return "/pages/address.jsp";
	   

	    }
	  @RequestMapping("/setDefault")
	  public String setDefault(@RequestParam("id") String eid,HttpSession session)
	  {
		 Integer id=Integer.parseInt(eid);
		TbUser user=(TbUser)session.getAttribute("tbuser");
		Integer uid=user.getUid();
		TbAddress addre=new TbAddress();
		addre.setId(id);
		addre.setUid(uid);
		List<TbAddress> addrs=addrservice.selectAll(uid);
		for(int i=0;i<addrs.size();i++)
		{
			if(addrs.get(i).getIsDefaultAddr()==null|| addrs.get(i).getIsDefaultAddr().equals("1"))
			{
				addrservice.update(uid);
			}
		}
		addrservice.update1(addre);
		return "/addr/select.do";
		  
	  }
}
