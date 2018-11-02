package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymal.commons.DBHelper;

public class ItemDao {
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

	
	public ArrayList<HashMap<String, Object>> itemList(Connection connection) throws SQLException {
		System.out.println("itemList 메서드 실행 ItemDao.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        preparedStatement = connection.prepareStatement("SELECT * FROM item");
        resultSet=preparedStatement.executeQuery();

        while(resultSet.next()) {
        	HashMap<String, Object> map = new HashMap<String , Object>();
            map.put("no", resultSet.getString("no"));
            map.put("name", resultSet.getString("name"));
            map.put("price", resultSet.getString("price"));
            list.add(map);
        }

		return list;
	}

}
