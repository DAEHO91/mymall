package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.MemberItem;

public class ItemService {

	private ItemDao itemDao;
	private MemberItemDao memberItemDao;
	
	SqlSession sqlSession = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public ArrayList<HashMap<String, Object>> itemList(){
		System.out.println("itemList 메서드... ItemService.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		try {
			sqlSession = DBHelper.getSqlSession();
			
			itemDao = new ItemDao();
			list = itemDao.itemList(sqlSession);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}	
		
		return list;
	}
	
	public void Order(MemberItem memberItem) {
		System.out.println("Order 메서드... ItemService.java");
		
		try {
			sqlSession = DBHelper.getSqlSession();
			
			memberItemDao = new MemberItemDao();
			memberItemDao.order(sqlSession, memberItem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	
}
