package com.lanqiao.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.Collection;
import com.lanqiao.domain.Wen;
import com.lanqiao.mapper.JayceMapper;
import com.lanqiao.service.ICollectionService;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	
	@Autowired
	private ICollectionService collectionService;
	
	@Autowired
	private JayceMapper jcMapper;
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Collection> selectCollection(Integer uid){
		return collectionService.selectCollectionByUid(uid);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public void insertCollection(Collection collection){
		collectionService.insertCollection(collection);
		Wen w = new Wen(collection.getUid(), collection.getGid(),0);
		w = jcMapper.SearchWenByWen(w);
		if(w==null){
			jcMapper.insertWen(new Wen(collection.getUid(),collection.getGid(),3));
		}else{
			if(w.getWen()==0){
				w.setWen(3);
				jcMapper.updateWen(w);
			}
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteCollection(Collection collection){
		collectionService.deleteCollection(collection);
	}

}
