package com.cook.talk.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.AdIngrDAO;
import com.cook.talk.model.dao.AdRecipeDAO;
import com.cook.talk.model.dao.AdUserDAO;
import com.cook.talk.model.dao.QnADAO;

@RestController
public class AdminRestController {
	@Autowired(required = false)
	private QnADAO qnaDAO;

	@Autowired(required = false)
	private AdUserDAO aduserDAO;

	@Autowired(required = false)
	private AdRecipeDAO adRecipeDAO;

	@Autowired(required = false)
	private AdIngrDAO adIngrDAO;

	@PostMapping("/admin/deleteUserID") // 모든 회원정보 뿌려주기 위해 public String
	public String deleteUserID(UserVO userId) {
		System.out.println(userId);
		aduserDAO.deleteUserID(userId);
		System.out.println("아 되자 제발" + userId);

		return "삭제되었습니다";

	}

	@PostMapping("/admin/updateUserNickName") // 닉네임 업데이트
	public String updateUserNickName(Model model, UserVO nickName) {
		System.out.println(nickName);
		aduserDAO.updateUserNickName(nickName);
		return "admin/adUser";
	}

	@PostMapping("/admin/complain")
	public void complain() {
		// insertReply(String UserID);
	}

	@PostMapping("/admin/adUser")
	public void adUser() {
		// deleteUserId(UserDTO userID);
		// searchUserByEmail(UserDTO userEmail);
		//
	}

	@PostMapping("/admin/adRecipe")
	public void adRecipe() {
	}

	@PostMapping("/admin/Ingr")
	public void Ingr() {
	}

	@PostMapping("/admin/qna") // qna 답변
	public String insertReply(UserVO userId, QnAVO qna) {

		return "admin";
	}

	@PostMapping("/admin/allSelectRecipe") // 모든 레시피 가져오기
	public String allSelectRecipe(Model model) {

		return "admin";
	}

	@PostMapping("/admin/updateRecipe") // 레시피 업데이트, (수정)
	public String updateRecipe(Model model, RecipeVO rcpUpdate) {

		return "admin";
	}

	@PostMapping("/admin/searchUserNickName") // 닉네임 찾아서 레시피 찾기
	public String searchRecipeByNickName(Model model, UserVO userNickName) {

		return "admin";
	}

	@PostMapping("/admin/BiRcpStatic") // 통계 뿌려주기위해
	public String searchRcpByRcpCode(Model model, String rcpCode) {
		/*
		 * searchRcpByRcpCode, selectStaticMonths, selectStaticsAge, selectStaticsGender
		 */
		return "admin";
	}

	// 재료 추가

}
