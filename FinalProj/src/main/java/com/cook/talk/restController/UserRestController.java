package com.cook.talk.restController;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.UserDAO;
import com.cook.talk.model.service.UserService;

@RestController

public class UserRestController {

   @Autowired
   UserDAO userDAO;
   @Autowired
   UserService userServce;

   @RequestMapping("/idCheck.do")
   @ResponseBody
   public int idCheck(@RequestBody String userId) {
      int count=0;
      count=userDAO.userIdCheck(userId);
      System.out.println(userId);
      return count;

   }

   @RequestMapping(value = "/nickNameCheck", method = RequestMethod.POST, produces = "application/json; charset=utf8")
   @ResponseBody
   public Map<String, Boolean> nickNameCheck(String user_nickName) {
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      int check_num = userDAO.userNickNameCheck(user_nickName);

      if (check_num > 0)
         map.put("check", false);
      else
         map.put("check", true);

      return map;
   }

}