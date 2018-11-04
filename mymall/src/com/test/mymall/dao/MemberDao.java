package com.test.mymall.dao;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;

public class MemberDao {
	
	private static String namespace = "com.test.mymall.dao.MemberMapper";

	public Member login(SqlSession sqlSession, Member member) {
		System.out.println("login Method Access MemberDao.java");
        return sqlSession.selectOne(namespace+".login", member);	
	}
	
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("insertMember Method Access MemberDao.java");
		sqlSession.insert(namespace+".insertMember", member);
	}
	
	public Member selectMember(SqlSession sqlSession, String id) {
		System.out.println("selectMember Method Access MemberDao.java");
		return sqlSession.selectOne(namespace+".selectMember", id);
	}
	
	public void updateMember(SqlSession sqlSession, Member member) {
		System.out.println("updateMember Method Access MemberDao.java");
		sqlSession.update(namespace+".updateMember", member);
	}
	
	public void deleteMember(SqlSession sqlSession, Member member) {
		System.out.println("deleteMember Method Access MemberDao.java");
		sqlSession.delete(namespace+".deleteMember", member);
	}
	
	public int deleteCheckMember(SqlSession sqlSession, Member member)  {
		System.out.println("deleteCheckMember Method Access MemberDao.java");
		return ((Integer)sqlSession.selectOne(namespace+".deleteCheckMember", member)).intValue();
	}
	
	
}
