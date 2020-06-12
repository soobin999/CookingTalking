package com.cook.talk.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.UnknownException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

@Controller
public class NaverLoginController {
	private String CLIENT_ID = "u6KAIfOc1yx4jmLjgUOp";
	private String CLIENT_SECRET = "umLqVBhv_e";

	// 로그인 컨트롤러
	@RequestMapping("/naver")
	public String testNaver(HttpSession session, Model model) throws UnknownException, UnsupportedEncodingException {

		String redirectURI = URLEncoder.encode("http://localhost:8080/naver/index", "UTF-8");

		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += String.format("&client_id=%s&redirect_uri=%s&state=%s", CLIENT_ID, redirectURI, state);
		session.setAttribute("state", state);

		model.addAttribute("apiURL", apiURL);
		return "test-naver";
	}

	

	}

