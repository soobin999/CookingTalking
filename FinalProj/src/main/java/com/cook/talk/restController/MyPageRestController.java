package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dto.MyPageDTO;
import com.cook.talk.model.service.MyPageService;



@RestController
public class MyPageRestController {

	@Autowired(required = false)
	MyPageService myPageService;
	
	@PostMapping("/written")
	public List<MyPageDTO> myRecipeWritten() {
		
		List<MyPageDTO> myRecipeWritten = myPageService.getMyRecipeWritten();
		
		return myRecipeWritten;
	}
	
	
}
