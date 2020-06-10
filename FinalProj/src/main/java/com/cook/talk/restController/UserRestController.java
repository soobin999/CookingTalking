package com.cook.talk.restController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.UserDAO;

@RestController

public class UserRestController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/idCheck", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		int result = userDAO.idCheck(userId);
		return Integer.toString(result);

//아이디 값만 중복되는지 확인하기 때문에 String 형식 

	}



}

