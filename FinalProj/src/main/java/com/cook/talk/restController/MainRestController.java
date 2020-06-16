package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.MainDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class MainRestController {

	@Autowired
	MainDAO maindao;
	@PostMapping("/autoComplete")
	public String autoComplete(String searchWord) throws JsonProcessingException {
		System.out.println(searchWord);
		List<String> list=maindao.selectTitle(searchWord);
		ObjectMapper mapper=new ObjectMapper();
		
		JSONPObject json=new JSONPObject("JSON.parse", list);
		return mapper.writeValueAsString(list);
	}
	
	@PostMapping("/chefsearch")
	public String chefsearch(String chefNick) {
		System.out.println(chefNick);
		maindao.selectChef(chefNick);
		System.out.println(maindao.selectChef(chefNick));
		return "성공";
	}
}
