package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {

	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	SqlSession sqlSession = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public void updateMember(Member member) {
		System.out.println("updateMember  Method Access ... MemberService.java");
		try {
			sqlSession = DBHelper.getSqlSession();
			
			memberDao = new MemberDao();
			memberDao.updateMember(sqlSession, member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public Member selectMember(String id) {
		
		System.out.println("selectMember  Method Access ... MemberService.java");
		Member selectMember = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			
			memberDao = new MemberDao();
			selectMember = memberDao.selectMember(sqlSession, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return selectMember;
	}
	
	
	
	public boolean deleteMember(Member member) {
		System.out.println("deleteMember  Method Access ... MemberService.java");
		boolean check= false;
		try {
			sqlSession = DBHelper.getSqlSession();
			// �ڵ�Ŀ��false
			//sqlSession.setAutoCommit(false);

			memberDao = new MemberDao();
			memberItemDao = new MemberItemDao();

			check = memberDao.deleteCheckMember(sqlSession, member);
			//login check
			if(check) {
				memberItemDao.deleteMemberItem(sqlSession, member);
				memberDao.deleteMember(sqlSession, member);
			}
			
			sqlSession.commit();
			System.out.println(check+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<java");

		} catch(Exception e) {
			try {
				// ���� �߻��� �ѹ�..
				sqlSession.rollback();
			} finally {
				sqlSession.close();
			}
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return check;
	}
	
	
	
	public Member login(Member member) {
		System.out.println("login  Method Access ... MemberService.java");
		memberDao = new MemberDao();
		Member loginmember = new Member();
		
		try {
			sqlSession = DBHelper.getSqlSession();
			loginmember = memberDao.login(sqlSession, member);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return loginmember;
	}
	
	
	
	public void addMember(Member member) {
		System.out.println("addMember  Method Access ... MemberService.java");
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession, member);
			sqlSession.commit();
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}	
	}
}
