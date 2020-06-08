package com.cook.talk.model.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dao.ChefDAO;
import com.cook.talk.model.dao.MainDAO;
import com.cook.talk.model.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired(required = false)
	private ChefDAO chef;
	@Autowired(required = false)
	private MainDAO main;

	@Override
	public List<RecipeVO> recipeList(String expl) {

		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);

		// parameter 세팅
		// REST API 호출
		String result = restTemplate.postForObject("http://localhost:5000/recommend", expl, String.class);
		result = result.substring(2, result.length());
		result = result.substring(0, result.length() - 3);
		String[] re = result.split("\",\"");
		List<String> rcpCodeList=new ArrayList<String>();
		for (String k:re) {
			rcpCodeList.add(k);
		}
		main.recipeList(rcpCodeList);
		
		return main.recipeList(rcpCodeList);
	}

}
