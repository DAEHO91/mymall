package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Item;

public class ItemService {

	private ItemDao itemDao;
	private MemberItemDao memberItemDao;
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public ArrayList<HashMap<String, Object>> itemList(){
		System.out.println("itemList ¸Þ¼­µå... ItemService.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		try {
			connection = DBHelper.getConnection();
			
			itemDao = new ItemDao();
			list = itemDao.itemList(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
			
		
		return list;
	}
	
}
