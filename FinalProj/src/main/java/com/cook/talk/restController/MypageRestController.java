package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.dto.MypageDTO;
import com.cook.talk.model.service.MypageService;



@RestController
public class MypageRestController {

	@Autowired(required = false)
	MypageService mypageService;
	
	@Autowired(required = false)
	MypageDAO mypageDAO;
	
	@PostMapping("/written")
	public List<MypageDTO> myRecipeWritten(Model model) {
		List<MypageDTO> myRecipeWritten = mypageService.getMyRecipeWritten();
	
		model.addAttribute("myWritten", mypageDAO.getMyRecipeWritten());
		return myRecipeWritten;
	}
	
	@PostMapping("/scraped")
	public List<MypageDTO> myScrapedRecipe(Model model){
		List<MypageDTO> myScrapedRecipe = mypageService.getMyScrapedRecipe();
	
		model.addAttribute("myScraped", mypageDAO.getMyScrapedRecipe());
		return myScrapedRecipe;
	}
	
	@PostMapping("/myCom")
	public List<MypageDTO> myCom(Model model){
		List<MypageDTO> myCom = mypageService.getMyCom();
				
		model.addAttribute("myCom", mypageDAO.getMyCom());
		return myCom;
	}
	
	@PostMapping("/myRcpCom")
	public List<MypageDTO> myRcpCom(Model model){
		List<MypageDTO> myRcpCom = mypageService.getMyRcpCom();
			
		model.addAttribute("myRcpCom", mypageDAO.getMyRcpCom());
		return myRcpCom;
	}
	
	
	@PostMapping("/myInq")
	public List<MypageDTO> myInqList(Model model){
		List<MypageDTO> myInq = mypageService.getMyInq();
		
		model.addAttribute("myInq", mypageDAO.getmyInq());
		return myInq;
	}
}
