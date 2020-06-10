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
      user.setUserId("grand@naver.com");
      user.setUserPw(hhaa.encode("0000"));
      user.setNickName("하나하나");
      user.setBirth(new Date(1994 - 06 - 05));
      user.setGender(true);
      user.setAccess(1);
      user.setAuth(0);

      userDao.join(user);

   }
}

      