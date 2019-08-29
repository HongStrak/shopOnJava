package com.lanqiao.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.Collection;
import com.lanqiao.service.ICollectionService;

@Controller
@RequestMapping("/collection")
public class CollectionController {
	
	@Autowired
	private ICollectionService collectionService;
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Collection> selectCollection(Integer uid){
		return collectionService.selectCollectionByUid(uid);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public void insertCollection(Collection collection){
		collectionService.insertCollection(collection);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteCollection(Collection collection){
		collectionService.deleteCollection(collection);
	}

}
