package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	
	
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	//�α��� ���н� -> null
	//�α��� ������ -> ������ Member ��ü
	public Member login(Member member) {
		System.out.println("login �޼��� ���� MemberDao.java");
        Member loginMember = new Member();
		
        try {
        	connection = DBHelper.getConnection();
        
            preparedStatement = connection.prepareStatement("SELECT id, level FROM member WHERE id=? AND pw=?");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPw());
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
            	loginMember.setId(resultSet.getString("id"));
            	loginMember.setLevel(resultSet.getInt("level"));
            }
            
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
        	
		return loginMember;
	}
	
	
	public void insertMember(Member member) {
		System.out.println("insertMember �޼��� ���� MemberDao.java");
        
        try {
        	connection = DBHelper.getConnection();
        	
            preparedStatement = connection.prepareStatement("INSERT INTO member (id, pw, level) VALUE (?, ?, ?)");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPw());
            preparedStatement.setInt(3, member.getLevel());
            
            preparedStatement.executeUpdate();
        	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
	}
	
	public Member selectMember(String id) {
		System.out.println("selectMember �޼��� ���� MemberDao.java");
		Member getMember = new Member();
		
        try {
        	connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement("SELECT no, id, pw, level FROM member WHERE id=?");
            preparedStatement.setString(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
            	getMember.setNo(resultSet.getInt("no"));
            	getMember.setId(resultSet.getString("id"));
            	getMember.setPw(resultSet.getString("pw"));
            	getMember.setLevel(resultSet.getInt("level"));
            }
        	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
		
		return getMember;
	};
	
	public void updateMember(Member member) {
		System.out.println("updateMember �޼��� ���� MemberDao.java");
        try {
        	connection = DBHelper.getConnection();

            preparedStatement = connection.prepareStatement("Update member SET pw=?, level=? WHERE no=? AND id=?");
            preparedStatement.setString(1, member.getPw());
            preparedStatement.setInt(2, member.getLevel());
            preparedStatement.setInt(3, member.getNo());
            preparedStatement.setString(4, member.getId());
            
            preparedStatement.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBHelper.close(connection, preparedStatement, resultSet);
	}

};
	
	
}
