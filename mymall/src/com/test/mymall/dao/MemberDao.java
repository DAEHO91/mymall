package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.mymall.vo.Member;

public class MemberDao {
	
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	//�α��� ���н� -> null
	//�α��� ������ -> ������ Member ��ü
	public Member login(Connection connection, Member member) throws SQLException {
		System.out.println("login �޼��� ���� MemberDao.java");
        Member loginMember = null;

        preparedStatement = connection.prepareStatement("SELECT no, id, level FROM member WHERE id=? AND pw=?");
        preparedStatement.setString(1, member.getId());
        preparedStatement.setString(2, member.getPw());
            
        resultSet = preparedStatement.executeQuery();
            
        while(resultSet.next()) {
	        loginMember = new Member();
	        loginMember.setNo(resultSet.getInt("no"));
	        loginMember.setId(resultSet.getString("id"));
	        loginMember.setLevel(resultSet.getInt("level"));
        }
        preparedStatement.close();
        resultSet.close();
            	
		return loginMember;
	}
	
	
	public void insertMember(Connection connection, Member member) throws SQLException {
		System.out.println("insertMember �޼��� ���� MemberDao.java");

        preparedStatement = connection.prepareStatement("INSERT INTO member (id, pw, level) VALUE (?, ?, ?)");
        preparedStatement.setString(1, member.getId());
        preparedStatement.setString(2, member.getPw());
        preparedStatement.setInt(3, member.getLevel());
            
        preparedStatement.executeUpdate();
        	
        preparedStatement.close();
	}
	
	public Member selectMember(Connection connection, String id) throws SQLException {
		System.out.println("selectMember �޼��� ���� MemberDao.java");
		Member getMember = new Member();

        preparedStatement = connection.prepareStatement("SELECT no, id, pw, level FROM member WHERE id=?");
        preparedStatement.setString(1, id);
            
        resultSet = preparedStatement.executeQuery();
            
        while(resultSet.next()) {
        	getMember.setNo(resultSet.getInt("no"));
            getMember.setId(resultSet.getString("id"));
            getMember.setPw(resultSet.getString("pw"));
            getMember.setLevel(resultSet.getInt("level"));
        }
	
		return getMember;
	}
	
	public void updateMember(Connection connection, Member member) throws SQLException {
		System.out.println("updateMember �޼��� ���� MemberDao.java");
		
		preparedStatement = connection.prepareStatement("Update member SET pw=?, level=? WHERE no=? AND id=?");
        preparedStatement.setString(1, member.getPw());
        preparedStatement.setInt(2, member.getLevel());
        preparedStatement.setInt(3, member.getNo());
        preparedStatement.setString(4, member.getId());
            
        preparedStatement.executeUpdate();

	}
	
	public void deleteMember(Connection connection, Member member) throws SQLException {
		System.out.println("deleteMember �޼��� ���� MemberDao.java");
		
		preparedStatement = connection.prepareStatement("DELETE FROM member WHERE id=? AND pw=?");
        preparedStatement.setString(1, member.getId());
        preparedStatement.setString(2, member.getPw());
		
        preparedStatement.executeUpdate();
        	
	}
	
	
}
