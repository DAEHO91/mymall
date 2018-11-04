package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> orderList(SqlSession sqlSession, Member member) {
		System.out.println("orderList Method Access MemberItemDao.java");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if(member.getLevel()==0) {
			System.out.println("..Get User Order Info MemberItemDao.java");
			list = sqlSession.selectList(namespace+".userOrderList", member);
        } else if(member.getLevel()==1) {
        	System.out.println("..Get Admin Order Info MemberItemDao.java");
        	list = sqlSession.selectList(namespace+".adminOrderList", member);
        }
		return list;
        	
	}
	
	
}
