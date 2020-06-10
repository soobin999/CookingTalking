
package com.cook.talk.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.dao.UserDAO;

@Service
public abstract class UserServiceImpl implements UserDAO {
	@Autowired
	UserDAO userDAO;

	@Override
	public int idCheck(String userId) {
		int result = userDAO.idCheck(userId);
		return result;
	}

}
