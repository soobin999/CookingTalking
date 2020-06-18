package com.cook.talk.model.dao;

import java.util.Optional;

//Simport javax.xml.ws.ServiceMode;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.UserVO;

@Mapper
//@ServiceMode

public interface UserDAO {

	public int userIdCheck(String userId);

	public int userNickNameCheck(String nickName);

	// 닉네임 중복 체크
	public int updateUser(UserVO userVO);

	public UserVO findUserById(String id);

	public void join(UserVO user) throws Exception;

	public static int login(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Optional<UserVO> findByEmail(String userEmail);

	public static void setPassword(String encode) {
		// TODO Auto-generated method stub

	}

	public static int getuserId(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

public void updateAccess(String userId);

}