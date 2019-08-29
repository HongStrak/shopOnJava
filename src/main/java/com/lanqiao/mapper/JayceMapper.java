package com.lanqiao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Commodity;
import com.lanqiao.domain.Wen;

@Mapper
public interface JayceMapper {

	public List<Commodity> HotSell(Integer num);
	
	public List<Commodity> SearchByName(String gname);
	
	public int[] SearchILike(int uid);
	
	public List<Commodity> SearchSameCom(int tid);
	
	public ArrayList<Wen> SearchWen(int uid);
	
	public List<Commodity> SelectAllCom();
	
	public void insertWen(Wen wen);
	
	public Wen SearchWenByWen(Wen wen);
}
