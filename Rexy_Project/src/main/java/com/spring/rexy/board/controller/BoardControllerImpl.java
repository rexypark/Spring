package com.spring.rexy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.rexy.board.service.BoardService;
import com.spring.rexy.board.vo.BoardVO;

@Controller
public class BoardControllerImpl implements BoardController{

	@Autowired
	BoardService boardService;
	
	@Override
	@RequestMapping(value = "/getList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getList(BoardVO vo, ModelAndView mav) {
		System.out.println(vo.getSearchCondition() + " || " + vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		List<BoardVO> list = boardService.getList(vo);
		
		mav.addObject("list", list);
		mav.setViewName("/views/getBoardList.jsp");
		
		return mav;
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		//key : 제목, value : TITLE
		//key : 내용, value : CONTENT
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	
	@RequestMapping(value = "/getJsonData", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<BoardVO> getJsonList(BoardVO vo) {
		System.out.println("getJsonList");
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		List<BoardVO> list = boardService.getList(vo); 
		
		return list;
		
	}
}
