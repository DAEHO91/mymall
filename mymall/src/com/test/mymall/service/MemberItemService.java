package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberItemService {

	private MemberItemDao memberItemDao;
	
	SqlSession sqlSession = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	public List<Map<String, Object>> orderList(Member member) {
		System.out.println("orderList  Method Access ... MemberItemService.java");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		
		try {
			sqlSession = DBHelper.getSqlSession();
			
			memberItemDao = new MemberItemDao();
			list = memberItemDao.orderList(sqlSession, member);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}	
		
		return list;
	}
	
}
