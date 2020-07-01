
package com.cook.talk.model.serviceImpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.UserDTO;
import com.cook.talk.model.service.UserService;

@Service
public class UserloginServiceImpl implements UserService {

	@Autowired
	UserDTO userDTO;

	//아이디 체크
	@Override
	public int userIdCheck(String userId) {
		return 0;
	}

	@Override
	public void joinUser(@Valid UserVO userVO) {

	}
	//닉네임체크
	@Override
	public int nickNameCheck(String nickName) {
		return 0;
	}
}
