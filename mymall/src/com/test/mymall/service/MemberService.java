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
	
	public void updateMember(Member member) {
		System.out.println("updateMember �޼���... MemberService.java");
		try {
			connection = DBHelper.getConnection();
			
			memberDao = new MemberDao();
			memberDao.updateMember(connection, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}
	}
	
	
	public Member selectMember(String id) {
		
		System.out.println("selectMember �޼���... MemberService.java");
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
	
	
	
	public boolean deleteMember(Member member) {
		System.out.println("deleteMember �޼���... MemberService.java");
		boolean check= false;
		try {
			connection = DBHelper.getConnection();
			// �ڵ�Ŀ��false
			connection.setAutoCommit(false);

			memberDao = new MemberDao();
			memberItemDao = new MemberItemDao();

			check = memberDao.deleteCheckMember(connection, member);
			//��й�ȣ Ʋ���� false �� �����������
			if(check) {
				memberItemDao.deleteMemberItem(connection, member);
				memberDao.deleteMember(connection, member);
			}

			//commit
			connection.commit();

		} catch(Exception e) {
			try {
				// ���� �߻��� �ѹ�..
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
		
		return check;
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
			memberDao.insertMember(connection, member);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}	
	}
}
