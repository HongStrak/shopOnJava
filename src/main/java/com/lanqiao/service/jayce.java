package com.lanqiao.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.lanqiao.domain.Comment;
import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.Recommend;
import com.lanqiao.domain.TbUser;
import com.lanqiao.domain.Wen;
import com.lanqiao.mapper.JayceMapper;
import com.lanqiao.mapper.RecommendMapper;
import com.lanqiao.mapper.TbUserMapper;
import com.lanqiao.service.serviceImpl.*;
@Service
public class jayce implements Ijayce{
	
	@Autowired
	private JayceMapper jcMapper;
	
	@Autowired
	private TbUserMapper userMapper;

	@Autowired
	private RecommendMapper recommendMapper;
	
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
            System.out.println(data);
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
	
	
	@Override
	public List<Commodity> SelectAllCom(){
		return jcMapper.SelectAllCom();
	}
	
	@Override
	public List<TbUser> compute(){
		List<TbUser> listu = userMapper.selectAll();
		List<Commodity> listc = jcMapper.SelectAllCom();
		for(TbUser u:listu){
			for(Commodity c:listc){
				List<Wen> l = jcMapper.SearchWen(u.getUid());
				int i=0;
				for(Wen w:l){
					if(c.getGid()==w.getGid()){
						i=w.getWen();
					}
				}
				u.getWen().add(i);
			}
		}
		return listu;
	}
	
	@Override
	public void browse(int uid,int gid){
		Wen w = new Wen(uid, gid,0);
		w = jcMapper.SearchWenByWen(w);
		if(w==null){
			jcMapper.insertWen(new Wen(uid,gid,1));
		}else{
			if(w.getWen()==0){
				w.setWen(1);
			}
		}
		
	}
	
	public void userCF() {
		List<TbUser> users = compute();
		int men = users.size();
		List<Commodity> comms = SelectAllCom();
		int shops = comms.size();
		int grade[][] = new int[men][shops];
		int ii = 0;
		for (TbUser user : users) {
			int j=0;
			List<Integer> array = user.getWen();
			for (Integer arr : array) {
				grade[ii][j++] = arr;
			}
			ii++;
		}
		
			
			double $cos[][] = new double[men][men];
			for(int k=0; k<men;k++) {
				for(int j=0; j< men;j++) {
					double $x0 = 0;
					double $x1 = 0;
					int $y[] = new int[men];
					for(int i=0; i<shops; i++) {
						$y[j] = $y[j] + grade[k][i]*grade[j][i]; 
						$x0 = $x0 +grade[k][i]*grade[k][i]; 
						$x1 = $x1 +grade[j][i]*grade[j][i]; 
					}
					$cos[k][j] = (double)Math.round(($y[j]/(Math.sqrt($x0)*Math.sqrt($x1)))*100)/100;
				}
			}
			
			//推荐列表 = 相似度矩阵 X 评分矩阵
			double recom[][] = new double[men][shops];
			
			for(int k=0;k<shops;k++) {
				for(int i=0;i<men;i++) {
					double $x = 0;
					for(int j=0;j<men;j++) {
						$x = $x + $cos[i][j]*grade[j][k];
					}
					recom[i][k] = $x;
				}
			}
			
			for(int i=0;i<men;i++) {
				for(int j=0;j<shops;j++) {
					if(recom[i][j] > 3) {
						Integer uid = users.get(i).getUid();
						Integer gid = comms.get(j).getGid();
						//插入到数据库中
						recommendMapper.insertRecommend(new Recommend(uid,gid,recom[i][j]));
					}
				}
			}
			
			
			
	}
}
