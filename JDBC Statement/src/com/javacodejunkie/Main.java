package com.javacodejunkie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String dbUrl = "jdbc:mariadb://localhost:3306/tutorial";
		String user = "root";
		String password = "password";

		try {
			connection = Database.getConnection(dbUrl, user, password);
			System.out.println("Database connecion successful");
			
			statement = connection.createStatement();
			
//			// Type 1 - DDL - booolean execute(String sql)
//			String sql = "CREATE TABLE IF NOT EXISTS users (id int NOT NULL AUTO_INCREMENT, user_id VARCHAR(30) NOT NULL, PRIMARY KEY (id), UNIQUE KEY (user_id))";
//
//			statement.execute(sql);
			
//			String sql = "INSERT INTO users (user_id) VALUES ('santa369')";
//			
//			statement.executeUpdate(sql);
			
			String sql = "SELECT * FROM users";
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("user_id"));
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(resultSet);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}

	}

}
