package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.service.TalkService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/talk/*")
@Controller
@Log4j
@AllArgsConstructor
public class TalkContoller {
@Autowired
	private TalkService service;

//목록 
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", service.getTalkList());
	return "talk/list";
	}

//등록
	@PostMapping("/insert")
	public String insert(TalkVO talkVO, RedirectAttributes rttr) {
		service.insert(talkVO);
	//	rttr.addFlashAttribute("result", talkVO.getTalkCode());
		return "redirect:/talk/list";
	}

//수정 
	@PostMapping("/update")
	public String update(TalkVO talkVO, RedirectAttributes rttr) {
		log.info("update:" + talkVO);
		if (service.update(talkVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/talk/list";

	}

//삭제 


}