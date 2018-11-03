package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;

public class MemberDao {
	
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

	public Member login(SqlSession sqlSession, Member member) {
		System.out.println("login Method Access MemberDao.java");
        return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);	
	}
	
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("insertMember Method Access MemberDao.java");
		sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
	
	public Member selectMember(SqlSession sqlSession, String id) {
		System.out.println("selectMember Method Access MemberDao.java");
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.selectMember", id);
	}
	
	public void updateMember(SqlSession sqlSession, Member member) {
		System.out.println("updateMember Method Access MemberDao.java");
		sqlSession.update("com.test.mymall.dao.MemberMapper.updateMember", member);
	}
	
	public void deleteMember(SqlSession sqlSession, Member member) throws SQLException {
		System.out.println("deleteMember Method Access MemberDao.java");
		sqlSession.delete("com.test.mymall.dao.MemberMapper.deleteMember", member);
	}
	
	public boolean deleteCheckMember(SqlSession sqlSession, Member member) throws SQLException  {
		System.out.println("deleteCheckMember Method Access MemberDao.java");
		boolean result=false;
		resultSet=sqlSession.selectOne("com.test.mymall.dao.MemberMapper.deleteCheckMember", member);
		if(resultSet.next()) {
			result=true;
		}
		resultSet.close();
		return result;
	}
	
	
}
