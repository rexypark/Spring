package com.spring.rexy.usr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rexy.usr.dao.UserDAOImpl;
import com.spring.rexy.usr.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAOImpl userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return null;
	}
}
