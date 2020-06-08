package com.cook.talk.model.dto;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.UserVO;

import lombok.Data;

@Data
public class UserDTO {

	private UserVO user;
	private QnAVO qna;
	
	public static CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}