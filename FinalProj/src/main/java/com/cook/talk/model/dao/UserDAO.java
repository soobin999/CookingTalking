package com.cook.talk.model.dao;

import java.util.Optional;

//Simport javax.xml.ws.ServiceMode;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.UserVO;

@Mapper
//@ServiceMode

public interface UserDAO {
	
	public int userIdCheck(String userId);
	
	// 닉네임 중복 체크
	public int userNickNameCheck(String nickName);

	public int updateUser(UserVO userVO);

	public UserVO findUserById(String id);

	public void join(UserVO user) throws Exception;

	public int login(UserVO userVO);

	public Optional<UserVO> findByEmail(String userEmail);

	public static void setPassword(String encode) {
	}

	public static int getuserId(UserVO userVO) {
		return 0;
	}

	public void updateAccess(String userId);

}