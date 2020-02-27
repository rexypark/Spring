package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	//메소드에 선언된 @ModelAttribute는 리턴된 데이터를 View에 전달
	//@ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행 됨
	//뷰에 전달될때 설정 된 명칭(예:conditionMap)
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		//key : 제목, value : TITLE
		//key : 내용, value : CONTENT
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,
	                           BoardDAO boardDAO, 
	                           Model model) {
		System.out.println(">>> 글 전체 목록 조회 처리");
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null) {
			vo.setSearchCondition("");
		}
		
		System.out.println("vo.getSearchCondition() : " + vo.getSearchCondition());
		System.out.println("vo.getSearchKeyword() : " + vo.getSearchKeyword());
		
		
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo.getSearchCondition(), vo.getSearchKeyword());
		//List<BoardVO> boardList = boardDAO.getBoardList();
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoardDetail(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 글 상세 조회 처리");
		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board); //데이터 저장
		return "getBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
