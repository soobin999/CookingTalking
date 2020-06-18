package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.VO.IngrVO;
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
	public String updateUserNickName(@ModelAttribute UserVO userVO) {
		System.out.println(userVO.getUserId());
		System.out.println(userVO);
		System.out.println(userVO.getNickName());
		aduserDAO.updateUserNickName(userVO);
		return "수정되었습니다.";
	}

	// 재료 란.
	/*
	 * @PostMapping("/admin/deleteIngr") // 재료 삭제 public void deleteIngr(Model
	 * model, IngrVO ingrVO) { adIngrDAO.deleteIngr(ingrVO);
	 * 
	 * }
	 */
	@PostMapping("/admin/deleteIngr2")
	public String deleteIngr2(@RequestBody List<String> rcpingrCode) {
		System.out.println(rcpingrCode);
		adIngrDAO.deleteIngr(rcpingrCode);
		System.out.println(rcpingrCode + "삭제되었습니다.");

		/*
		 * System.out.println(ingrName + "문제가 무엇일까요"); System.out.println(ingrVO +
		 * "문제가 무엇일까요");
		 * 
		 * List<String> list = ingrName;
		 * 
		 * List<Map> deletelist = adIngrDAO.deleteIngr(list);
		 * 
		 * for (int i = 0; i < deletelist.size(); i++) {
		 * System.out.println(deletelist.get(i)); }
		 */

		return "삭제되었습니다";
	}

	@PostMapping("/admin/search")
	public List<IngrVO> searchIngr(@RequestParam("ingrName") String ingrVO) {
		System.out.println(ingrVO);
		adIngrDAO.searchIngr(ingrVO);
		System.out.println(adIngrDAO.searchIngr(ingrVO));
		return adIngrDAO.searchIngr(ingrVO);
	}

	// (value = "${Ingr.ingrName}")

	@PostMapping("/admin/complain")
	public void complain() {
		// insertReply(String UserID);
	}

	@PostMapping("/admin/adRecipe")
	public void adRecipe() {
	}

	@PostMapping("/admin/Ingr")
	public void Ingr() {
	}

	@PostMapping("/admin/qnaAnswer") // qna 답변
	public String insertReply(@ModelAttribute QnAVO qna) {
		System.out.println(qna.getUserId());
		System.out.println(qna);
		qnaDAO.insertReply(qna);
		return "추가되었습니다.";
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