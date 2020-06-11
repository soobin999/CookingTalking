package com.cook.talk.model.dao;

import java.util.Optional;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.UserVO;

@Mapper

@Service



public interface UserDAO {


	public int idCheck(String userId);
	//아이디 중복체크 
	public int userNickCheck(String nickName);
	//닉네임 중복 체크 
	public int updateUser(UserVO userVO);

	public UserVO findUserById(String id);

	public void join(UserVO user) throws Exception;

	public int login(UserVO userVO);

	public Optional<UserVO> findByEmail(String userEmail);

	public static void setPassword(String encode) {
		// TODO Auto-generated method stub

	}


}
