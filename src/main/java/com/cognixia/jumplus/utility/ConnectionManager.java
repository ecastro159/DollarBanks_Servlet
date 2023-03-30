package com.cognixia.jumplus.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static Connection connection = null;

	private static void makeConnection() {
//		Properties props = new Properties();
//
//		try {
//			props.load(new FileInputStream("/DollarBanks_Servlet/src/main/java/com/cognixia/jumplus/utility/config_properties"));
//		} catch (IOException e) {
//			System.out.println("Can not load File");
//			e.printStackTrace();
//		}

//		String url = props.getProperty("url");
		String url = "jdbc:mysql://localhost:3306/Project1Java?serverTimezone=EST5EDT";
//		String userpassword = props.getProperty("username");
		String userpassword= "root";
//		String password = props.getProperty("password");
		String password = "Root@123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userpassword, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		return connection;
	}

	// Test Connection
	public static void main(String[] args) {
		Connection conn = ConnectionManager.getConnection();
		System.out.println("Made Connection");

		try {
			conn.close();
			System.out.println("Closed Connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
