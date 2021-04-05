package com.javacodejunkie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection getConnection(String dbUrl, String user, String password) throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, user, password);
		connection.setAutoCommit(true);
		return connection;

	}

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		
		String dbUrl = "jdbc:mariadb://localhost:3306/tutorial";
		String user = "root";
		String password = "password";
		
		try {
			connection = Database.getConnection(dbUrl, user, password);
			System.out.println("Database connecion successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
