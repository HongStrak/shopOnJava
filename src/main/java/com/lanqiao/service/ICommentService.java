package com.lanqiao.service;

import java.util.List;
import java.util.Map;

import com.lanqiao.domain.Comment;


public interface ICommentService {
	   public void update(Comment comment);
		
		
		public void delete	(Comment comment);
		
	
		
		public List<Map> selectByPrimaryKey(Comment comment);
		
		public void insert(Comment comment);
		
		public void insertPraise(Comment comment);

}
