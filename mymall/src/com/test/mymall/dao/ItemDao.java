package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.Member;

public class ItemDao {
	
	private static String namespace = "com.test.mymall.dao.ItemMapper";

	public Member login(SqlSession sqlSession, Member member) {
		System.out.println("login Method Access MemberDao.java");
        return sqlSession.selectOne(namespace+".login", member);	
	}

	public List<Map<String, Object>> itemList(SqlSession sqlSession) {
		System.out.println("itemList Method Access itemDao.java");
		return sqlSession.selectList(namespace+".itemList");
	}

}
