package com.lanqiao.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Collection;
import com.lanqiao.mapper.CollectionMapper;
import com.lanqiao.service.ICollectionService;

@Service
public class CollectionServiceImpl implements ICollectionService{
	
	@Autowired
	private CollectionMapper collectionMapper;

	@Override
	public List<Collection> selectCollectionByUid(Integer uid) {
		// TODO Auto-generated method stub
		return collectionMapper.selectCollectionByUid(uid);
	}

	@Override
	public void insertCollection(Collection collection) {
		collectionMapper.insertCollection(collection);
		
	}

	@Override
	public void deleteCollection(Collection collection) {
		collectionMapper.deleteCollection(collection);
		
	}
	
	
	

}
