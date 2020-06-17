package com.cook.talk.controller;

import java.util.List;

import org.elasticsearch.common.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.service.TalkService;

import lombok.AllArgsConstructor;

@Controller

public class TalkController {
	@Inject
	TalkService talkservice;
	
	//private TalkService talkService;

	
	//게시판 글 작성 화면 
	 @RequestMapping(value = "/wirteView", method = RequestMethod.GET)
	 public void wirteView() throws Exception {
	  
	 }
	 
	 
	 //게시판 목록 
		@GetMapping("/talk/talkList")
		public ModelAndView talkList() throws Exception{
			List<TalkVO> list= talkservice.listAll();
			ModelAndView mav= new ModelAndView();
			mav.setViewName("talk/list");//뷰를 list.로 설정 
			mav.addObject("list",list);//데이터 저장 
			return mav;
			//list. 로 List전달
		}
	
		
	
		
		
		
	@PostMapping("/talk/talkDelete")
	public String talkDelete() {
		
		return "/talk";
	}
	@PostMapping("/talk/talkUpdate")
	public String talkUpdate() {
		
		return "/talk";
	}
	@PostMapping("/talk/comInsert")
	public String comInsert() {
		
		return "/talkCom";
	}
	@PostMapping("/talk/comDelete")
	public String comDelete() {
		
		return "/talkCom";
	}

	@PostMapping("/talk/talkSearch")
	public String talkSearch() {
		
		return "/talk";
	}
	
	
}
