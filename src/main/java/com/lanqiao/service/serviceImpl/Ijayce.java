package com.lanqiao.service.serviceImpl;

import java.util.List;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.TbUser;

public interface Ijayce {
	public String SendRandomCode(String phone,String code);
	
	
	public String randomCode();
	
	//热销
	public List<Commodity> HotSell(int num);
	
	//搜索
	public List<Commodity> SearchByName(String gname);
	
	public List<Commodity> SearchILike(int uid);
	
	public List<TbUser> compute();
	
	public List<Commodity> SelectAllCom();
	
	public void userCF();
}

