package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//1. 전달받은 값 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. 업무처리 - DB연동 작업(삭제)
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		dao.deleteBoard(vo);
		
		//3. 화면 네비게이션 처리(목록 페이지로)
		ModelAndView  mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}
}
