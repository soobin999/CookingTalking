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
	
	//마이페이지-사용자 개인 사진 수정페이지로 가기
	@GetMapping("/mypage/userPic")
	public String userPic() {
		
		return "/mypage/myPic";
	}
	
	//마이페이지-레시피-나의 작성중인 레시피
	@GetMapping("/mypage/myRecipeIng")
	public String myRecipeIng(Model model) {
		model.addAttribute("myRecipeIng", mypageDAO.getMyRecipeIng());
		System.out.println(mypageDAO.getMyRecipeIng());
		return "/mypage/myRecipeIng";
	}
	
	//마이페이지-레시피-나의 작성완료된 레시피
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
	  
	  
		@PostMapping("/mypage/modifyUserPic")
		public String modifyUserPic(UserVO userVO, Model model, 
				@RequestParam("file") MultipartFile multipartfile) {
			
			model.addAttribute("userPicMsg", "요청하신 사진으로 등록이 완료되었습니다");
			System.out.println("multipart :: " + multipartfile.getOriginalFilename());
			userVO.setUserPic(multipartfile.getOriginalFilename());
			mypageService.modifyUserPic(userVO.getUserPic(), multipartfile);
			System.out.println("추가된 파일명:" + multipartfile);
			System.out.println("userPic:"+userVO.getUserPic());
			
			return "/mypage/myRecipeIng";
		}
	 
	
}
