package com.spring.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("board") //board 라는 이름의 Model이 있으면 session에 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		boardService = new BoardServiceImpl();
	}
	
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
	                           Model model) {
		System.out.println(">>> 글 전체 목록 조회 처리");
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		System.out.println("vo.getSearchCondition() : " + vo.getSearchCondition());
		System.out.println("vo.getSearchKeyword() : " + vo.getSearchKeyword());
		
		//List<BoardVO> boardList = boardService.getBoardList(vo.getSearchCondition(), vo.getSearchKeyword());
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoardDetail(BoardVO vo, Model model) {
		System.out.println(">>> 글 상세 조회 처리");
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board", board); //데이터 저장
		System.out.println("board : " + board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글등록 처리");
		
		/* *** 파일 업로드 처리 ***
		 * MultipartFile 인터페이스 주요 메소드
		 * String fileName = uploadFile.getOriginalFilename(); : 업로드한 파일명 찾기
		 * void transferTo(File desFile) : 업로드한 파일을 destFile에 저장
		 * boolean isEmpty() : 업로드한 파일에 존재 여부
		 * */
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println("uploadFile : " + uploadFile);
		if(!uploadFile.isEmpty()) {//파일이 있으면(비어있지 않으면)
			String fileName = uploadFile.getOriginalFilename();
			try {
				uploadFile.transferTo(new File("c:/MyStudy/temp/" + fileName));
			} catch (IllegalStateException e) {
				System.out.println("IllegalStateException 발생");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException 발생");
				e.printStackTrace();
			}
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//@ModelAttribute board라는 이름으로 모델 속성명에 저장된 값이 있으면 가져다 쓰고 없으면 새로 생성한다.
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("board vo : " + vo);
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	//===============================================
	@RequestMapping("/dataTransform.do")
	@ResponseBody //response 객체의 몸체(body)에 데이터를 전달
	public List<BoardVO> dataTransform(BoardVO vo) {
		
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
		
	}
	
	@RequestMapping("/getJsonList.do")
	@ResponseBody //response 객체의 몸체(body)에 데이터를 전달
	public List<BoardVO> getJsonList(BoardVO vo) {
		
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
		
	}
	
	
	
	
}//end class



