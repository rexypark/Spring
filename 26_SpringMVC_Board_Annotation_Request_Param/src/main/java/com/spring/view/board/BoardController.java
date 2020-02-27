package com.spring.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) 
							    String condition, 
							    @RequestParam(value="searchKeyword", defaultValue="CONTENT", required=false) 
							    String keyword, 
	                           BoardDAO boardDAO, 
	                           Model model) {
		System.out.println(">>> 글 전체 목록 조회 처리");
		List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);
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
