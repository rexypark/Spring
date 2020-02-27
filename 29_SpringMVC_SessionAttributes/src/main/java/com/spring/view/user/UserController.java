package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
//@RequestMapping("/user") //메소드 요청 URL앞에 공통 적용
public class UserController {
	//get방식 일때 login.do요청 처리
	// 별도 명칭 부여 안하면 <데이터 타입> 첫글자 소문자로 작성된 명칭 사용됨
	//@ModelAttribute : 모델의 속성값으로 지정(속성명 별도 지정)
	// @ModelAttribute UserVO vo : 속성명이 userVO gudxo
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">> 로그인 화면으로 이동 - login()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	//post방식 일때 login.do요청 처리
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>> 로그인 처리");
		System.out.println("전달받은 vo : " + vo);
		
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		
		session.invalidate();
		return "login.jsp";
	}
}
