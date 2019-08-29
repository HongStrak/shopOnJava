package com.lanqiao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.lanqiao.domain.Comment;


@Mapper
public interface CommentMapper {
	
    public void update(Comment comment);
	
	
	public void delete	(Comment comment);
	
	
	public List<Map> selectByPrimaryKey(Comment comment);
	
	public void insert(Comment comment);
	
	public void insertPraise(Comment comment);


}
