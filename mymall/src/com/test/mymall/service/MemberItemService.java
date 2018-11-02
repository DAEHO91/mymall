package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberItemService {

	private MemberItemDao memberItemDao;
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	public ArrayList<HashMap<String, Object>> orderList(Member member) {
		System.out.println("orderList ¸Þ¼­µå... MemberItemService.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		
		try {
			connection = DBHelper.getConnection();
			
			memberItemDao = new MemberItemDao();
			list = memberItemDao.orderList(connection, member);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}	
		
		return list;
	}
	
}
