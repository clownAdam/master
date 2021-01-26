package com.kmmall.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	static String user;
	static String password;
	static String url;
	static String driver;
	static {
		Properties properties = new Properties();
		try {
			properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			 user= (String) properties.get("jdbc.user");
			 password= (String) properties.get("jdbc.password");
			 url= (String) properties.get("jdbc.host");
			 driver= (String) properties.get("jdbc.driver");
			
			Class.forName(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
	}
}
