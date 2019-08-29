package com.lanqiao.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanqiao.domain.Comment;
import com.lanqiao.mapper.CommentMapper;
import com.lanqiao.service.ICommentService;

@Service
public class ICommentServiceImpl implements  ICommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void update(Comment comment) {
		commentMapper.update(comment);
		
	}

	@Override
	public void delete(Comment comment) {
		commentMapper.delete(comment);
		
	}

	@Override
	public List<Map> selectByPrimaryKey(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(comment);
	}

	@Override
	public void insert(Comment comment) {
		commentMapper.insert(comment);
		
	}

	@Override
	public void insertPraise(Comment comment) {
		commentMapper.insertPraise(comment);
		
	}


}
