package com.test.mymall.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public List<Map<String, Object>> itemList(){
		System.out.println("itemList Method Access ... ItemService.java");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			sqlSession = DBHelper.getSqlSession();
			
			itemDao = new ItemDao();
			list = itemDao.itemList(sqlSession);
			System.out.println(list+"<<<< ItemService.java");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}	
		
		return list;
	}
	
	public void Order(MemberItem memberItem) {
		System.out.println("Order  Method Access ... ItemService.java");
		
		try {
			sqlSession = DBHelper.getSqlSession();
			
			memberItemDao = new MemberItemDao();
			//memberItemDao.order(sqlSession, memberItem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	
}
