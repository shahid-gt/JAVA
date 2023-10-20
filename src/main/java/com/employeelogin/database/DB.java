package com.employeelogin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection conn = null;
	public static final String dbname = "javalddb";

	public static Connection connect() throws ClassNotFoundException {
		// load and register JDBC driver for MySQL
		Class.forName("com.mysql.jdbc.Driver"); 

		try {
			String url = "jdbc:mysql://localhost:3306/";
			String username = "root";
			String password = "root@mysql";
			conn = DriverManager.getConnection(url + dbname, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}