package com.cook.talk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.service.TalkComService;
import com.cook.talk.model.service.TalkService;

import lombok.AllArgsConstructor;

@RequestMapping("/com")
public class TalkComController {
	
	@Autowired
	private TalkComService  comservice;
	@Autowired
	private TalkService talkservice;
	
	
@RequestMapping(value = "/comInsert.do", method = RequestMethod.POST)
@ResponseBody
public  String comInsert(TalkComVO comVO) {
	String talkComCode=comVO.getTalkComCode();
	comservice.comInsert(comVO);
	return "success";
}
/*
@RequestMapping("/comDelete.do")
public String deleteCom (HttpSession session,@PathVariable int talkComCode) {
	String talkComCode=(String)session.getAttribute("talkComCode");
			comservice.deleteCom(talkComCode);
			
			int 
}*/
	
	
/*	@PostMapping(value = "/new",
			consumes = "application/json", 
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody TalkComVO comVO){
		int insertCount = comService.comInsert(comVO);
		return insertCount==1
				? new ResponseEntity<>("success",HttpStatus.OK)
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				//삼항연산자 처리 
	}*/
	
	
	
	
	
	
	
	
}
