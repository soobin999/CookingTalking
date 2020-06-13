
package com.cook.talk.model.service;

import javax.validation.Valid;

import com.cook.talk.model.VO.UserVO;

public interface UserService {

	void joinUser(@Valid UserVO userVO);

	public int userIdCheck(String userId);
	//아이디 중복체크 
   
}