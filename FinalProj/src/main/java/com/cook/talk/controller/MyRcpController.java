package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@Controller
public class MyRcpController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;
	
	
	@GetMapping("/mypage/userPic")
	public String userPic() {
		
		return "/mypage/myPic";
	}
	
	@GetMapping("/mypage/myRecipeIng")
	public String myRecipeIng(Model model) {
		model.addAttribute("myRecipeIng", mypageDAO.getMyRecipeIng());
		System.out.println(mypageDAO.getMyRecipeIng());
		return "/mypage/myRecipeIng";
	}
	
	@GetMapping("/mypage/myWritten")
	public String myWritten(Model model) {
		model.addAttribute("myWritten", mypageDAO.getMyRecipeWritten());
		System.out.println(mypageDAO.getMyRecipeWritten());
		return "/mypage/myWritten";
	}
	
	
	  @GetMapping("/deleteRcp/{rcpCode}") 
	  public String deleteRcp(@PathVariable("rcpCode") String rcpCode) {
	  System.out.println("deleteRcp 실행 : "); 
	  mypageService.deleteRcp(rcpCode);
	  System.out.println("dao 끝 ");
	  
	  return "redirect:/mypage/myWritten"; 
	  
	  }
	 
	
}
