package com.cook.talk.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })
	public String insert(Model model, TalkVO talkVO) {
		String msg = "talk/wirte";
		service.insert(talkVO);
		return msg;
	//	return "redirect:/talk/list";
	}

	//등록 버튼 
	@RequestMapping("/insert.do")
	public ModelAndView insert(TalkVO talkVO) throws Exception{
		ModelAndView mav= new ModelAndView("redirect:/talk/list");
		service.insert(talkVO);
		return mav;
		
	}
	
	
	
	
	/*@RequestMapping(value = "/insert", method = { RequestMethod.POST, RequestMethod.GET })

	public String insert(TalkVO talkVO, RedirectAttributes rttr) {
<<<<<<< HEAD
		System.out.println(talkVO);
=======
>>>>>>> 56af16d43c2787599b5e647d4e7e1bda6e4f7737
		service.insert(talkVO);
	//	rttr.addFlashAttribute("result", talkVO.getTalkCode());
		return "redirect:/talk/list";
	}*/

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