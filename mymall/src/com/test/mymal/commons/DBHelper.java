package com.test.mymal.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBHelper {
	public static Connection getConnection() throws Exception{
    	System.out.println("DB연결실행 MemberDao.java");
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbID = "root";
        String dbPW = "java0000";
        connection = DriverManager.getConnection(jdbcDriver, dbID, dbPW);
        return connection;
	}
	
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if(resultSet != null) {
            try {resultSet.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(preparedStatement != null) {
            try {preparedStatement.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(connection != null) {
            try {connection.close();} catch(Exception exception){exception.printStackTrace();}
        }
    }
}
