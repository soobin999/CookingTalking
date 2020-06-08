
package com.cook.talk.model.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.UserDAO;


import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor

public class UserService implements UserDetailsService {
	private UserDAO userDAO;
	

	
	@Transactional
	public int joinUser(UserVO userVO) { // 비밀번호 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userVO.setUserPw(passwordEncoder.encode(userVO.getUserPw()));

		return userDAO.login(userVO);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     //입력한 아이디 값을 통해 디비에서 값을 읽어오는것.  디비에있으면userDto 객체에 로그인 정보 담는다. 
		UserVO userEntity = userDAO.findUserById(username);
		List<GrantedAuthority> authorities = new ArrayList<>();

		if ((userEntity.getUserId()).equals(username)) {
			authorities.add(new SimpleGrantedAuthority(userEntity.getAuth() == 0 ? Role.MEMBER.getValue() : null));

		} else {
			authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));

		}
		return new org.springframework.security.core.userdetails.User(userEntity.getUserId(), userEntity.getUserPw(), authorities);

	
	}

	

	}

