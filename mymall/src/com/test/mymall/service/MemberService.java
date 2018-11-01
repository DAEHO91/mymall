package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {

	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public void deleteMember(Member member) {
		System.out.println("deleteMember �޼���... MemberService.java");
		try {
			connection = DBHelper.getConnection();
			connection.setAutoCommit(false);
			// 1. ù��°���
			memberDao = new MemberDao();
			memberDao.deleteMember(connection, member);
			// 2. �ι�°���
			memberItemDao = new MemberItemDao();
			//memberItemDao.deleteMemberItem(connection, null);
			
			connection.commit();

		} catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				DBHelper.close(connection, preparedStatement, resultSet);
			}
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
	}
	
	public Member login(Member member) {
		System.out.println("login �޼���... MemberService.java");
		memberDao = new MemberDao();
		Member loginmember = new Member();
		
		try {
			connection = DBHelper.getConnection();
			loginmember = memberDao.login(connection, member);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
		return loginmember;
	}
	
	
	public void addMember(Member member) {
		System.out.println("addMember �޼���... MemberService.java");
		memberDao = new MemberDao();
		
		try {
			connection = DBHelper.getConnection();
			memberDao.insertMember(member);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}	
	}
}
