package com.cook.talk.model.dao;
import java.util.Optional;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.UserVO;


@Mapper
@Service
public interface UserDAO {
	
	
	public void insertUser(UserVO user);


	public int userIdCheck(String userId);


	public int userNickCheck(String nickName);

	public int updateUser(UserVO user);

	public UserVO findUserById(String id);

	void join(UserVO userVO) throws Exception;

	public int login(UserVO user);

	public Optional<UserVO> findByEmail(String userEmail);

	public static void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}
}
