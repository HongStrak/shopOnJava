package com.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Collection;

@Mapper
public interface CollectionMapper {
	
	public List<Collection> selectCollectionByUid(Integer uid);
	
	public void insertCollection(Collection collection);
	
	public void deleteCollection(Collection collection);

}
