package com.lanqiao.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.domain.Foot;
import com.lanqiao.service.IFootService;

@Controller
@RequestMapping("/foot")
public class FootController {

	@Autowired
	private IFootService footService;
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Foot> selectFoot(Foot foot){
		return footService.selectFootByUid(foot);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public void insertFoot(Foot foot){
		footService.insertFoot(foot);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteFoot(Foot foot){
		footService.deleteFoot(foot);
	}
	
	@PostMapping("/selectbygdate")
	@ResponseBody
	public Map selectBy(Foot foot){
	
	Map<String,Object> map = new HashMap<>();
	List<Foot> al = footService.selectFootByUid(foot);
	List<Map> gdates = footService.selectFootByGdate(foot);
	
	map.put("al", al);
	map.put("gdates", gdates);
	return map;
	}
	
	
	
}
