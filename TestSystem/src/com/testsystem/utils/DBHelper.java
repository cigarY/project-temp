package com.testsystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/look?useUnicode=true&characterEncoding=UTF-8";
	String user = "root";
	String password = "123456";
	
	private static DBHelper dbHelper = null;
	private Connection connection = null;
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DBHelper() {
		try {
			connection = DriverManager.getConnection(url, user, password);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBHelper getDbHelper() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	public ResultSet executeQuery(String sql) throws Exception {
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public ResultSet executeQuery(String sql, Object...args) throws Exception {
		PreparedStatement stmt = connection.prepareStatement(sql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				stmt.setObject(i+1, arg);
			}
		}
		return stmt.executeQuery();
	}
	
	public int executeUpdate(String sql) throws Exception {
		Statement stmt = connection.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public int executeUpdate(String sql, Object...args) throws Exception {
		PreparedStatement stmt = connection.prepareStatement(sql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				stmt.setObject(i+1, arg);
			}
		}
		return stmt.executeUpdate();
	}
	
	public void close() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection = null;
			dbHelper = null;
		}
	}
}
