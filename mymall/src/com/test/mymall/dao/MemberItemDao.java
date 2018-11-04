package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    private static String namespace = "com.test.mymall.dao.MemberItemMapper";
	
	
	public void deleteMemberItem(SqlSession sqlSession, Member member) {
		System.out.println("deleteMemberItem Method Access MemberItemDao.java");
		sqlSession.delete(namespace+".deleteMemberItem", member);
	}
	
	public int order(SqlSession sqlSession, MemberItem memberItem) {
		System.out.println("order Method Access MemberItemDao.java");
		return sqlSession.insert(namespace+".order", memberItem);
	}
	
	public ArrayList<HashMap<String, Object>> orderList(Connection connection, Member member) throws SQLException {
		System.out.println("orderList Method Access MemberItemDao.java");
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		if(member.getLevel()==0) { //��.. �ڽ��� �ֹ�����Ʈ�� ��ȸ
			System.out.println("0..Get Client Order Info MemberItemDao.java");
        	preparedStatement = connection.prepareStatement("SELECT mi.no, m.id, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no INNER JOIN member m ON mi.member_no = m.no WHERE mi.member_no = ?");
        	preparedStatement.setInt(1, member.getNo());
        } else if(member.getLevel()==1) { //������.. ��� �ֹ�����Ʈ ��ȸ
        	System.out.println("1..Get Admin Order Info MemberItemDao.java");
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
