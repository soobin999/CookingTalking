package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dao.AdIngrDAO;

@Controller
public class adIngrController {
	@Autowired(required = false)
	AdIngrDAO adingrDAO;

	@GetMapping("/admin/allSelectIngr") // 재료 뿌리기
	public String allSelectIngr(Model model) {
		model.addAttribute("IngrList", adingrDAO.allSelectIngr());

		return "admin/adIngrList2";
	}

	@PostMapping("/admin/searchIngr") // 재료 찾기
	public String searchIngr(Model model, IngrVO ingrVO) {
		model.addAttribute("searchIngrList", adingrDAO.searchIngr(ingrVO));

		return "admin/adIngrList";
	}

	@PostMapping("/admin/insertIngr") // 재료 추가
	public String insertIngr(Model model, IngrVO ingrVO) {

		return "admin/adIngrList";
	}

	@PostMapping("/admin/deleteIngr") // 재료 삭제
	public void deleteIngr(Model model, IngrVO ingrVO) {

	}

}
