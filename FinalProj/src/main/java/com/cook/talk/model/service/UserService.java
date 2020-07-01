
package com.cook.talk.model.service;

import javax.validation.Valid;

import com.cook.talk.model.VO.UserVO;

public interface UserService {

	void joinUser(@Valid UserVO userVO);

	public int userIdCheck(String userId);
	//아이디 중복체크 

	//닉네임 중복체크
	public int nickNameCheck(String nickName);

	/*
	 * static int getuserId(UserVO userVO) { // TODO Auto-generated method stub
	 * return 0; }
	 */


}