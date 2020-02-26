package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

//@Service : @Component 상속바아 만든
//비즈니스 로직 처리 서비스 영역에 사용
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired // Autowired > 프로젝트 내에 선언된 객체타입을 찾아 선언 시켜줌
	//@Qualifier("userDAO")
	private UserDAO userDAO; 

	public UserServiceImpl() {System.out.println("유저impl 실행");}
	
	@Override
	public UserVO getUser(UserVO vo) {
		
		return userDAO.getUser(vo);
	}
}