package com.lanqiao.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.domain.Comment;
import com.lanqiao.service.ICommentService;

@RestController
@CrossOrigin
@RequestMapping("/commen")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
@PostMapping("/select1") 
	public Map selectComment(Comment comment,Integer cp){
		//return commentService.selectByPrimaryKey(comment);
		Map<String, Object> map=new HashMap<>();
		if(cp==null){
			cp=1;
		}
	    PageHelper.startPage(cp, 2);
		List<Map> items = commentService.selectByPrimaryKey(comment);
		System.out.println(items.size());
		PageInfo<Map> page = new PageInfo<>(items);
		
		System.out.println(page.getList());
		map.put("page", page);
	    map.put("cp", cp);
	
		return map;
    }
     


   @PostMapping("/select")
   public List<Map> selectComment1(Comment comment){
	 return commentService.selectByPrimaryKey(comment);
}
   
   @PostMapping("/update")
   public void updatePraise(Comment comment){
	   commentService.update(comment);
   }
  
}
