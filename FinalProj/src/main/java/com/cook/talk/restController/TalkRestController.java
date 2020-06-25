package com.cook.talk.restController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.service.TalkComService;

import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;
@RequestMapping("/com")
@RestController
@AllArgsConstructor
@Log4j
public class TalkRestController {
private TalkComService comservice;
/*
	@PostMapping(value = "/new",consumes = "application/json",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertCom(@RequestBody TalkComVO comVO){
		int insertCount =comservice.createCom(comVO);
		
	}*/
}
