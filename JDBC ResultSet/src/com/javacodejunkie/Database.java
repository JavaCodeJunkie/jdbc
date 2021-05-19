package com.javacodejunkie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static Connection getConnection(String dbUrl, String user, String password) throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, user, password);
		connection.setAutoCommit(true);
		return connection;

	}

	public static void closeConnection(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException exception) {
			// exception.printStackTrace();
		}

	}

	public static void closeStatement(Statement statement) {

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException exception) {
			// exception.printStackTrace();
		}

	}

	public static void closeResultSet(ResultSet resultSet) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException exception) {
			// exception.printStackTrace();
		}

	}
}
