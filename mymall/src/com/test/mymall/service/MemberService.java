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
	
	public Member selectMember(String id) {
		
		System.out.println("selectMember 메서드... MemberService.java");
		Member selectMember = new Member();
		try {
			connection = DBHelper.getConnection();
			
			memberDao = new MemberDao();
			selectMember = memberDao.selectMember(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
		
		return selectMember;
	}
	
	
	
	public void deleteMember(Member member) {
		System.out.println("deleteMember 메서드... MemberService.java");
		try {
			connection = DBHelper.getConnection();
			connection.setAutoCommit(false);
			// 1. 첫번째기능
			memberDao = new MemberDao();
			memberDao.deleteMember(connection, member);
			// 2. 두번째기능
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
		System.out.println("login 메서드... MemberService.java");
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
		System.out.println("addMember 메서드... MemberService.java");
		memberDao = new MemberDao();
		
		try {
			connection = DBHelper.getConnection();
			memberDao.insertMember(connection, member);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}	
	}
}
