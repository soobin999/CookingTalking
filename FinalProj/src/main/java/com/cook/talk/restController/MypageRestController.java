package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.dto.MypageDTO;
import com.cook.talk.model.service.MypageService;

@RestController
public class MypageRestController {

	@Autowired(required = false)
	MypageDAO mypageDAO;
	
	@Autowired(required = false)
	MypageService mypageService;
	
	
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
	
	@PostMapping("/searchMyFollow")
	public List<MypageDTO> getSearchMyFollow(String followChef){
		System.out.println(followChef);
		System.out.println(mypageService.getSearchMyFollow(followChef));

		return mypageService.getSearchMyFollow(followChef);

	}
	
	@PostMapping("/searchMyTalk")
	public List<MypageDTO> getSearchMyTalk(String talkCont) {
		System.out.println(talkCont);
		System.out.println(mypageService.getSearchMyTalk(talkCont));
		return mypageService.getSearchMyTalk(talkCont);
	}
	
	
	
	@PostMapping("/searchMyScrap")
	public List<MypageDTO> getSearchMyScraped(String rcpTitle){
		System.out.println(rcpTitle);
		System.out.println(mypageService.getSearchMyScraped(rcpTitle));
		return mypageService.getSearchMyScraped(rcpTitle);
	}
	
	@PostMapping("/searchMyAllCom")
	public List<MypageDTO> getSearchAllMyCom(String talkCom){
		System.out.println(talkCom);
		System.out.println(mypageService.getSearchAllMyCom(talkCom));
		return mypageService.getSearchAllMyCom(talkCom);
	}
	
	@PostMapping("/searchMyTalkCom")
	public List<MypageDTO> getSearchTalkCom(String talkCom){
		System.out.println(talkCom);
		System.out.println(mypageService.getSearchTalkCom(talkCom));
		return mypageService.getSearchTalkCom(talkCom);
	}
	
	
	@PostMapping("/searchMyRcpCom")
	public List<MypageDTO> getSearchRcpCom(String rcpCom) {
		System.out.println(rcpCom);
		System.out.println(mypageService.getSearchTalkCom(rcpCom));
		return mypageService.getSearchRcpCom(rcpCom);
	}
	 
	
	@PostMapping("/mypage/ans/{qnaCode}")
	public String showAns(@RequestParam("qnaCode") String qnaCode, RedirectAttributes rttr) {
		
		return "redirect:/mypage/myInquiryList";
	}
	
	
}
