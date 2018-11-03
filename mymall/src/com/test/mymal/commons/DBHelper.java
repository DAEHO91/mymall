package com.test.mymal.commons;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBHelper {
	public static SqlSession getSqlSession() throws Exception{
    	System.out.println("DB Connection MemberDao.java");
    	
    	InputStream inputStream = null;
    	  
		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		return sqlSession;

	}
   	/*
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbID = "root";
        String dbPW = "java0000";
        connection = DriverManager.getConnection(jdbcDriver, dbID, dbPW);
        return connection;
   	 */
	
}
