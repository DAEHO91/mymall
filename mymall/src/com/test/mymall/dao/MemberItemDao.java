package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	
	public void deleteMemberItem(Connection connection, Member member) throws SQLException {
		System.out.println("deleteMemberItem 메서드 실행 MemberItemDao.java");

	    preparedStatement = connection.prepareStatement("DELETE FROM member_item WHERE member_no=?");
	    preparedStatement.setInt(1, member.getNo());
	    	
	    preparedStatement.executeUpdate();
		
	}
	
	public void order(Connection connection, MemberItem memberItem) throws SQLException {
		System.out.println("order 메서드 실행 MemberItemDao.java");

        preparedStatement = connection.prepareStatement("INSERT INTO member_item (member_no, item_no, order_date) VALUE (?, ?, now())");
        preparedStatement.setInt(1, memberItem.getMember_no());
        preparedStatement.setInt(2, memberItem.getItem_no());
            
        preparedStatement.executeUpdate();
	}
	
	public ArrayList<HashMap<String, Object>> orderList(Connection connection, Member member) throws SQLException {
		System.out.println("orderList 메서드 실행 MemberItemDao.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		if(member.getLevel()==0) { //고객.. 자신의 주문리스트만 조회
			System.out.println("0의 조건실행 MemberItemDao.java");
        	preparedStatement = connection.prepareStatement("SELECT mi.no, m.id, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no INNER JOIN member m ON mi.member_no = m.no WHERE mi.member_no = ?");
        	preparedStatement.setInt(1, member.getNo());
        } else if(member.getLevel()==1) { //관리자.. 모든 주문리스트 조회
        	System.out.println("1의 조건실행 MemberItemDao.java");
        	preparedStatement = connection.prepareStatement("SELECT mi.no, m.id, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no INNER JOIN member m ON mi.member_no = m.no");
        }
        	
        resultSet = preparedStatement.executeQuery();
        	
        while(resultSet.next()) {
        	HashMap<String, Object> map = new HashMap<String , Object>();

            map.put("no", resultSet.getInt("mi.no"));
            map.put("id", resultSet.getString("m.id"));
            map.put("order_date", resultSet.getString("mi.order_date"));
            map.put("item_no", resultSet.getInt("mi.item_no"));
            map.put("name", resultSet.getString("i.name"));
            map.put("price", resultSet.getInt("i.price"));
            	
            list.add(map);
        }
 
		return list;
	}
	
	
}
