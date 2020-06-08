package com.cook.talk.model.dao;
import java.util.Optional;

import javax.xml.ws.ServiceMode;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.UserVO;


@Mapper


@ServiceMode

public interface UserDAO {
	
	
	public void insertUser(UserVO user);


	public int userIdCheck(String userId);


	public int userNickCheck(String nickName);

	public int updateUser(UserVO user);

	public UserVO findUserById(String id);

	void save(UserVO userVO) throws Exception;

	public int login(UserVO user);

	public Optional<UserVO> findByEmail(String userEmail);

	public static void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}
