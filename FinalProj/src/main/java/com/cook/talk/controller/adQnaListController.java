package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.dao.ChefDAO;
import com.cook.talk.model.dao.QnADAO;
import com.cook.talk.model.service.MainService;

@Controller
public class adQnaListController {

	@Autowired(required = false)
	private QnADAO qnADao;
	@GetMapping("/admin/adQnaList")
	public String selectqna(Model model) {
		model.addAttribute("adQnaList", qnADao.selectQna());

		return "admin/adQnaList";
	}


}
