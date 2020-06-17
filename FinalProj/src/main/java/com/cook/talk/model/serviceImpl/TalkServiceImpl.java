
package com.cook.talk.model.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.elasticsearch.common.inject.Inject;
import org.springframework.stereotype.Service;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dao.TalkDAO;
import com.cook.talk.model.service.TalkService;

@Service
public class TalkServiceImpl implements TalkService {
@Inject
private TalkDAO dao;

//게시글 쓰기
@Override
public void wirte(TalkVO talkVO)throws Exception{
	String content =talkVO.getTalkCont();
	
	content=content.replace("\n", "<br>");
	talkVO.setTalkCont(content);
	
}

//상세 보기
@Override
public TalkVO read(int talkCode) throws Exception {
	// TODO Auto-generated method stub
	return dao.read(talkCode);
}

//게시글 수정
@Override
public TalkVO update(TalkVO talkVO) throws Exception {
	// TODO Auto-generated method stub
	return dao.update(talkVO);
}


@Override
public void delete(int talkCode) throws Exception {
	// TODO Auto-generated method stub
	dao.delete(talkCode);

}

//r게시글 전체 목록
@Override
public List<TalkVO> listAll() throws Exception {
	// TODO Auto-generated method stub
	return dao.listAll();
}

//조회수 증가 
@Override
public void increaseViewcount(int talkCode, HttpSession session) throws Exception {
	// TODO Auto-generated method stub
	long update_time=0; //세션에 저장된 조회시간 검색 
	//최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if값 실행되지 않는다. 
	if(session.getAttribute("update_time"+talkCode)!=null) {
		update_time=(long)session.getAttribute("update_time"+talkCode);
		
	}
//시스템 현재 시간을 curent_time에 저장 
	long current_time= System.currentTimeMillis();
	//일정 시간 경과 후 조회수 증가 처리 26*60*60*6000 (24시간)
	//시스템 현재 시간-> 열람시간->일정시간 
	if(current_time - update_time >5*1000) {
		dao.increaseViewconut(talkCode);
		
		session.setAttribute("update_time"+talkCode, current_time);
	}
			
			
}
	



}
