package com.myspring.eium.hm.hm_p0039.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.eium.hm.hm_p0039.vo.HM_P0039VO;


public interface HM_P0039DAO {
	public List<HM_P0039VO> searchList(Map<String, Object> searchMap)throws DataAccessException;

}
