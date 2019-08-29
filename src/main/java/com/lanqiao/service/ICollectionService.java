package com.lanqiao.service;

import java.util.List;

import com.lanqiao.domain.Collection;

public interface ICollectionService {
	
	public List<Collection> selectCollectionByUid(Integer uid);
	
	public void insertCollection(Collection collection);
	
	public void deleteCollection(Collection collection);

}
