

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

	@Override public int userIdCheck(String userId) { 
		// TODO Auto-generatedmethod stub 
		return 0; 
  }

	@Override public void joinUser(@Valid UserVO userVO) { 
		// TODO Auto-generated method stub
 
  }
}
