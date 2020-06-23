package com.cook.talk.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TypeCatVO;
import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.TagVO;

import com.cook.talk.model.dao.RecipeDAO;

import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired(required = false)
	private RecipeDAO recipeDAO;
	@Autowired(required = false)
	private IngrVO ingrVO;

	// 재료 초성 분류
	public List<String> ingrNameList(int cs) {
		String[] chosungList = { "가", "나", "다", "라", "마", "바", "사", "아", "자", "차", "카", "타", "파", "하", "가" };

		List<String> ingrNameList = recipeDAO.getIngrName1(chosungList[cs], chosungList[cs + 1]);
		return ingrNameList;
	}

	@Override
	public String searched(IngrVO ingrVO) {
		if (ingrVO.getIngrName() != null) {
			ingrVO.getIngrName();
			return ingrVO.getIngrName();
		} else {
			return "일치하는 재료 없어요";
		}
	}

	@Override
	public List<RecipeDTO> getRcmmList(String selectedIngr) {
		List<RecipeDTO> getRcmmList = recipeDAO.getRcmmList(selectedIngr);

		return getRcmmList;
	}

	@Override
	public List<String> getSearchedIngrName(String ingrName) {
		// TODO Auto-generated method stub
		return recipeDAO.getSearchedIngrName(ingrName);
	}

	@Override
	public List<RecipeDTO> getRecipeList() {
		List<RecipeDTO> recipeList = recipeDAO.getRecipeList();
		return recipeList;
	}

	@Override
	public int recipeCount() {
		int recipeCount = recipeDAO.recipeCount();
		return recipeCount();
	}


	
		
	@Override
	public void insertRecipeProc(/*@RequestParam("rcpPic") MultipartFile file*/
			boolean registerStatus, RecipeVO recipeVO, TypeCatVO typeCatVO, RcpIngrVO rcpIngrVO, 
			RcpOrderVO rcpOrderVO,TagVO tagVO) {
		
//		String UPLOADED_FOLDER = "";
//		log.info(file+"파일");
		System.out.println("========");
		
		
		// 1.typeCat테이블 레코드 생성
		int tpcNum = recipeDAO.selectTypeCode() +1;
		typeCatVO.setTypeCode("TC-0000" +tpcNum);
		recipeDAO.insertTypecatProc(typeCatVO);
		
		log.info(typeCatVO);
	
	
		//2. rcp테이블 레코드 생성		
		int rcpNum = recipeDAO.selectRcpCode() +1;
		recipeVO.setRcpCode("R-000" +rcpNum);
		
		//생성한 typeCode를 가져와서 rcp테이블에 set한다
		recipeVO.setTypeCode(typeCatVO.getTypeCode()); 
		//registerStatus의 값을 set한다
		recipeVO.setRegisterStatus(registerStatus); 
		
		recipeDAO.insertRcpProc(recipeVO);
		log.info(recipeVO);
		
		
		//3. rcpIngr 테이블 생성
		int cncNum = recipeDAO.selectConnectcode() +1;
		rcpIngrVO.setConnectCode("RM-0000" +cncNum);
		//rcpCode를 rcpIngr의 rcpCode에 set한다
		rcpIngrVO.setRcpCode(recipeVO.getRcpCode());
		
		recipeDAO.insertRcpingrProc(rcpIngrVO);
		log.info(rcpIngrVO);		
		
		//4. rcporder 테이블 생성
		//rcpCode를 rcpOrder의 rcpCode에 set한다
		rcpOrderVO.setRcpCode(recipeVO.getRcpCode());
		
		recipeDAO.insertRcporderProc(rcpOrderVO);
		log.info(rcpOrderVO);
		
		//5. tag 테이블 생성
		//rcpCode를 rcpTagCode에 set한다
		tagVO.setRcpTagCode(recipeVO.getRcpCode());
		
		recipeDAO.insertTagProc(tagVO);
		log.info(tagVO);
	}
}
//		try {
//
//			// Get the file and save it somewhere
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//			Files.write(path, bytes);
//			return "ok";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "fail";
//		}



