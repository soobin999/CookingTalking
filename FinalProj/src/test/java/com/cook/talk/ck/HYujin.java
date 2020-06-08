package com.cook.talk.ck;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.UserDAO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class HYujin {

	@Autowired
	UserDAO userDao;

	@Test
	public void find() {
		log.info(userDao.findUserById("abc@naver.com").toString());
	}	
	@Test
	public void save() {


		UserVO user = new UserVO();
		user.setUserId("spd@naver.com");
		user.setUserPw("1234");
		user.setNickName("스파이더");
		user.setBirth(new Date(1994 - 06 - 05));


		user.setGender(true);
		user.setAccess(true);
		user.setAuth(0);


		userDao.login(user);

	}

}

		