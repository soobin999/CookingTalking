package com.cook.talk.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dao.TalkDAO;
import com.cook.talk.model.service.TalkService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/talk/*")
@Controller
@Log4j
@AllArgsConstructor
public class TalkContoller {
	@Autowired
	private TalkService talkservice;
	private TalkDAO talkDAO;

//목록 
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", talkservice.getTalkList());
		return "talk/list";
	}

//등록
	@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })
	public String insert(@ModelAttribute TalkVO talkVO) {
		String msg = "talk/wirte";
		return msg;
		// return "redirect:/talk/list";
	}

	// 등록 버튼
	@PostMapping("/insert.do")
	public String insertTalk(Principal principal, TalkVO talkVO) {
		// System.err.println(principal.toString());
		talkVO.setUserId(principal.getName());
		talkservice.insert(talkVO);
		return "redirect:/talk/list";

	}

//자세히 보기 

	@RequestMapping("/detail/{talkCode}")
	public String detail(HttpSession session, Model model, @PathVariable String talkCode) {
		session.setAttribute("talkCode", talkCode);
		model.addAttribute("talk", talkDAO.talkSearchById(talkCode));
		// model.addAttribute("commentList",)
		return "/talk/detail";

	}

//수정 

	@PostMapping("/update")
	public String update(TalkVO talkVO, RedirectAttributes rttr) {
		if (talkservice.update(talkVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/talk/list";
	}
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public String
	 * update(TalkVO talkVO,RedirectAttributes rttr) { if
	 * (talkservice.update(talkVO)) { rttr.addFlashAttribute("result", "success"); }
	 * return "redirect:/talk/list";
	 * 
	 * }
	 */

//삭제 
	/*
	 * @PostMapping("/delete") public String delete (@RequestParam("talkCode")
	 * RedirectAttributes rttr) { if(talkservice.delete(talkCode)) {
	 * rttr.addFlashAttribute("result","success"); } return "redirect:/talk/list"; }
	 */

}