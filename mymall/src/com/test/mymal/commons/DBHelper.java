package com.test.mymal.commons;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DBHelper {
	public static Connection getConnection() throws Exception{
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
	}
}
