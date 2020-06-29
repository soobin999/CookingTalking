package com.cook.talk.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.VO.UserVO;
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

	@RequestMapping(value = "/comInsert", method = RequestMethod.POST)
	@ResponseBody
	public String create(TalkComVO comVO, Principal principal, RedirectAttributes rttr) {

		rttr.addAttribute("comVO", comVO.getTalkComCode());
		comVO.setUserId(principal.getName());
		String talkCode = comVO.getTalkCode();
		String talkComCode = comVO.getTalkComCode();
		System.err.println(comVO);
		comservice.createCom(comVO);
		return "success";
	}
//댓글 수정 

	@RequestMapping(method = { RequestMethod.PUT,
			RequestMethod.PATCH }, value = "/update/{talkComCode}", consumes = "application/json", produces = {
					MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> updateCom(@RequestBody TalkComVO comVO,
			@PathVariable("talkComCode") String talkComCode) {
		comVO.setTalkComCode(talkComCode);
		return comservice.updateCom(comVO) == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	// 댓글 삭제
	/*
	 * @RequestMapping("/deletCom/{talkComCode}")
	 * 
	 * @ResponseBody public ResponseEntity<String>
	 * deleteCom(@PathVariable("talkComCode") String talkComCode) {
	 * ResponseEntity<String> entity = null; try {
	 * comservice.deleteCom(talkComCode); entity = new
	 * ResponseEntity<String>("success", HttpStatus.OK);
	 * System.out.println(entity+"entity");
	 * System.out.println(talkComCode+"talkCom"); } catch (Exception e) {
	 * e.printStackTrace(); entity = new ResponseEntity<String>(e.getMessage(),
	 * HttpStatus.BAD_REQUEST); System.out.println(entity+"error"); }
	 * 
	 * return entity;
	 * 
	 * }
	 */
	
	/*	@PostMapping("/deletCom/{talkComCode}")
	@ResponseBody
	public String deleteCom(HttpSession session, @PathVariable String talkComCode) {
		String talkCode = (String) session.getAttribute("talkComCode");
		comservice.deleteCom(talkComCode);
System.out.println(talkComCode);
System.out.println(session);
System.out.println(talkCode);
		return "redirect:talk/talkDetail";
	}
 */
	
	
	@PostMapping("/deletCom/{talkComCode}")
	@ResponseBody
	public String deleteCom(@PathVariable String talkComCode) {
		comservice.deleteCom(talkComCode);
System.out.println(talkComCode);
		return "redirect:talk/talkDetail";
	}

//댓글 목록 
	@RequestMapping("/list.do")
	public String listcom(@RequestParam String talkComCode, Model model) {
		model.addAttribute("talkCode", comservice.searchComment(talkComCode));
		return "talk/comTest";
	}

}
