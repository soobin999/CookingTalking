package com.cook.talk.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dao.TalkComDAO;
import com.cook.talk.model.dto.TalkDTO;
import com.cook.talk.model.service.TalkComService;
import com.cook.talk.model.service.TalkService;

@Controller
@RequestMapping("/com")
public class TalkComController {

	@Autowired
	private TalkComService comservice;
	@Autowired
	private TalkService talkservice;

	// 댓글 입력
	/*@RequestMapping(value = "/comInsert", method = RequestMethod.POST)
	@ResponseBody
	public String create(TalkComVO comVO, Principal principal,RedirectAttributes rttr) {
		System.err.println(comVO);
		//rttr.addAttribute("comVO",comVO.getTalkComCode());
		comVO.setUserId(principal.getName());
		String talkCode = comVO.getTalkCode();
		return "success";
	}*/
	
	@RequestMapping(value = "/comInsert/{talkComCode}", method = RequestMethod.POST)
	@ResponseBody
	public String insert (TalkComVO comVO, HttpSession session, @RequestParam(value ="talkCom")String talkCom 
			, @RequestParam(value = "talkComCode")@PathVariable  String talkComCode) {
	
		if(session.getAttribute("userId") !=null) {
			String userId=(String) session.getAttribute("userId");
			comVO.setUserId(userId);
			
		}
		comVO.setTalkCom(talkCom);
		comVO.setTalkComCode(talkComCode);
	comservice.createCom(comVO);
	return "success";
	}
	
	
	
	
	
	
	

	// 댓글 삭제
	@RequestMapping("/deletCom/{talkComCode}")
	public String deleteCom(HttpSession session, @PathVariable String talkComCode) {
		String talkCode = (String) session.getAttribute("talkCode");
		comservice.deleteCom(talkComCode);
		int talkComCount = comservice.comcount(talkCode);
		return "talk/detail";
	}

//댓글 목록 
	@RequestMapping("/list.do")
	public String listcom(@RequestParam String talkComCode, Model model) {
		model.addAttribute("talkCode", comservice.searchComment(talkComCode));
		return "talk/comTest";
	}

	// ajax test

	@RequestMapping("/comTest")
	public String comTest() {
		return "/talk/comTest";
	}

	/*
	 * @RequestMapping("/comDelete.do") public String deleteCom (HttpSession
	 * session,@PathVariable int talkComCode) { String
	 * talkComCode=(String)session.getAttribute("talkComCode");
	 * comservice.deleteCom(talkComCode);
	 * 
	 * int }
	 */

	/*
	 * @PostMapping(value = "/new", consumes = "application/json", produces =
	 * {MediaType.TEXT_PLAIN_VALUE}) public ResponseEntity<String>
	 * create(@RequestBody TalkComVO comVO){ int insertCount =
	 * comService.comInsert(comVO); return insertCount==1 ? new
	 * ResponseEntity<>("success",HttpStatus.OK) : new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //삼항연산자 처리 }
	 */

}
