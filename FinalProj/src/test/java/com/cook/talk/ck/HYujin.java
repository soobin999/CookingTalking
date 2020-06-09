package com.cook.talk.ck;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.UserDAO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class HYujin {

	   @Autowired
	   UserDAO userDao;
	      
	   @Autowired
	   BCryptPasswordEncoder hhaa;
	   @Test
	   public void find() {
	      log.info(userDao.findUserById("abc@naver.com").toString());
	   }

	   @Test
	   public void save() throws Exception {


	      UserVO user = new UserVO();
	      user.setUserId("haha@naver.com");
	      user.setUserPw(hhaa.encode("1234"));
	      user.setNickName("요리하하");
	      user.setBirth(new Date(1994 - 06 - 05));
	      user.setGender(true);
	      user.setAccess(true);
	      user.setAuth(0);

	      userDao.join(user);

	   }
	}

	      