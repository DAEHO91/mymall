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
		System.out.println("login �޼��� ���� MemberDao.java");
        return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);	
	}
	
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("insertMember �޼��� ���� MemberDao.java");
		sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
	
	public Member selectMember(SqlSession sqlSession, String id) {
		System.out.println("selectMember �޼��� ���� MemberDao.java");
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.selectMember", id);
	}
	
	public void updateMember(SqlSession sqlSession, Member member) {
		System.out.println("updateMember �޼��� ���� MemberDao.java");
		sqlSession.update("com.test.mymall.dao.MemberMapper.updateMember", member);
	}
	
	public void deleteMember(Connection connection, Member member) throws SQLException {
		System.out.println("deleteMember �޼��� ���� MemberDao.java");
		
		preparedStatement = connection.prepareStatement("DELETE FROM member WHERE id=?");
        preparedStatement.setString(1, member.getId()); 
		
        preparedStatement.executeUpdate();
        
        preparedStatement.close();

        	
	}
	
	public boolean deleteCheckMember(Connection connection, Member member) throws SQLException  {
		System.out.println("deleteCheckMember �޼��� ���� MemberDao.java");
		boolean check = false;
		
		preparedStatement = connection.prepareStatement("SELECT id FROM member WHERE id=? AND pw=?");
		preparedStatement.setString(1, member.getId()); 
		preparedStatement.setString(2, member.getPw()); 
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			check = true;
		}
		
        preparedStatement.close();
        resultSet.close();
		
		return check;
	}
	
	
}
