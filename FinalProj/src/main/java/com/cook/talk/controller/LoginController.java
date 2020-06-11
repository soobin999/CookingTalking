package com.cook.talk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.elasticsearch.client.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.UserDAO;
import com.cook.talk.model.dto.UserDTO;
import com.cook.talk.model.service.UserService;
import com.cook.talk.model.serviceImpl.UserServiceImpl;

import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice.Return;

@AllArgsConstructor

@Controller
public class LoginController {
	@Autowired
	private UserVO userVO;
	@Autowired
	private UserDAO userDAO;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest req) {
		model.addAttribute("message", req.getServletContext());
		return "/login/login";
	}

	@RequestMapping("goJoin")
	public String goJoin() {
		return "join";
	}

	@PostMapping("/login/find_pw")
	public String find_pw() {
		return "/login/login";
	}

	@PostMapping("/login/userUpdate")
	public String userUpdate() {
		return "/login/login";
	}

	@PostMapping("/login/userDelete")
	public String userDelete() {
		return "/login/login";
	}

	@PostMapping("/login/re_pw")
	public String re_pw() {
		return "/login/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

	@GetMapping("/admin")
	public String adminPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
		model.put("currentAdminId", user.getUsername());
		return "adminpage";
	}

	@RequestMapping(value = "/gologin", method = RequestMethod.GET)
	public String gologin(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		// re가 null이 아니거나 refer가 null 이 아닌 경우
		if (request.getRequestURL() != null && request.getHeader("referer") != null) {
			// 이전 페이지가 로그인겟 이거나 직접 로그인 url에 접속하지 않았을 경우 referer 저장
			if (!(request.getRequestURL().equals("/login/gologin")
					&& request.getHeader("referer").equals("http://localhost/login/gologin"))) {
				// dest세션에 이전 페이지 정보 저장
				session.setAttribute("dest", request.getHeader("referer"));
			}
		}
		return "/user/login";
	}

	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(UserVO userVO) {
		return "join/join";
	}// 화면보여주는 것.

	
	@PostMapping("/join")
	public String execJoin(@Valid UserVO userVO, Errors errors, Model model) {
		userServiceImpl.joinUser(userVO);
		return "redirect:/index";

	}// 기능

	
	@PostMapping("/join2")
	public String execJoin(@Valid UserDTO userDTO, Errors errors, Model model) {
		// @Valid 입력데이터가 dto클래스로 캡슐화 되어 넘어올때 유효성을 체크하라는 어노테이션이다 /dto의 어노테니션 기준으로 체크
		if (errors.hasErrors()) {
			// 회원가입 실패시, 입력 데이터를 유지
			model.addAttribute("userDTO", userDTO);
			// errors.hasErrors() // 유효성 통과 못한 필드와 메세지 핸들링 유효성 검사에 실패한 필드가 있는지 확인.
			UserVO userVO = new UserVO();
			userVO.setUserId(userDTO.getUserId());
			userVO.setUserPw(userDTO.getUserPw());
			userServiceImpl.joinUser(userVO);
			return "redirect:/login/login";
		}
		
		Map<String, String> validatorResult = UserServiceImpl.validateHandling(errors);
		for (String key : validatorResult.keySet()) {
			model.addAttribute(key, validatorResult.get(key));
		}

		return "/join/join";

	}

}