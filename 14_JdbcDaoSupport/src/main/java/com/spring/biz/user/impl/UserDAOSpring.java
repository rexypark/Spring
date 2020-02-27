package com.spring.biz.user.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring extends JdbcDaoSupport {
	private final String USER_GET
	= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";

	void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	
	public UserVO getUser(UserVO vo) {
		System.out.println("====> Spring JDBC로 updateBoard() 실행");
		
		Object[] args = {vo.getId(), vo.getPassword()};
		return getJdbcTemplate().queryForObject(USER_GET, args, new UserRowMapper());
	}
}
