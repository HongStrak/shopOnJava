package com.lanqiao.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.lanqiao.domain.Commodity;
import com.lanqiao.mapper.JayceMapper;
import com.lanqiao.service.serviceImpl.*;
@Service
public class jayce implements Ijayce{
	
	@Autowired
	private JayceMapper jcMapper;

	@Override   //随机发送验证码
	public String SendRandomCode(String phone,String code) {
		
		String data="";
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI7b2J0gT3hh8h", "qZTNdLme41KdD8nXMRswdl1IG0506Z");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "个人云笔记");
        request.putQueryParameter("TemplateCode", "SMS_171853605");
        
        request.putQueryParameter("TemplateParam", "{'code':'"+code+"'}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            data=response.getData();
            System.out.println(response.getData());
        } catch (ServerException e) {
    //        e.printStackTrace();
            return "false";
        } catch (ClientException e) {
  //          e.printStackTrace();
            return "false";
        }
		return data;
	}
	
	
	@Override  //生成验证码
	public String randomCode(){
		String code = "";
		for(int i=0;i<6;i++){
			String r = Math.random()*10+"";
			code+=r.split("\\.")[0];
		}
		return code;
	}
	
	@Override  //热销num为热销前几
	public List<Commodity> HotSell(int num){
		List<Commodity> hotList=jcMapper.HotSell(num);
		return hotList;
	}

	@Override
	public List<Commodity> SearchByName(String gname){
		List<Commodity> com = jcMapper.SearchByName(gname);
		return com;
	}


	@Override
	public List<Commodity> SearchILike(int uid) {
		int[] a = jcMapper.SearchILike(uid);
		List list = jcMapper.SearchSameCom(a[0]);
		list.addAll(jcMapper.SearchSameCom(a[1]));
		return list;
	}
}
