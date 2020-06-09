package com.cook.talk.restController;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.UserDTO;
import com.cook.talk.model.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class UserRestController {

	private UserService userService;

	@GetMapping("/join")
	public String disapJoin(UserDTO userDTO) {
		return "join/join";
	}

	@PostMapping("/join")
	public String execJoin(@Valid UserDTO userDTO, Errors errors, Model model) {
		// @Valid 입력데이터가 dto클래스로 캡슐화 되어 넘어올때 유효성을 체크하라는 어노테이션이다 /dto의 어노테니션 기준으로 체크

		if (errors.hasErrors()) {
			// 회원가입 실패시, 입력 데이터를 유지
			model.addAttribute("userDtO", userDTO);
			// errors.hasErrors()
			// 유효성 통과 못한 필드와 메세지 핸들링 유효성 검사에 실패한 필드가 있는지 확인.
			UserVO userVO = new UserVO();
			userVO.setUserId(userDTO.getUserId());
			userVO.setUserPw(userDTO.getUserPw());
			userService.joinUser(userVO);
			return "redirect:/login/login";
		}

		Map<String, String> validatorResult = userService.validateHandling(errors);
		for (String key : validatorResult.keySet()) {
			model.addAttribute(key, validatorResult.get(key));

		}
		return "/join/join";

	}

}

	

