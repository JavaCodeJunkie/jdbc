package com.javacodejunkie;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		String dbUrl = "jdbc:mariadb://localhost:3306/tutorial";
		String user = "root";
		String password = "password";

		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Database.getConnection(dbUrl, user, password);
			System.out.println("Database connection successful");

			// Let's Make a Plan

			// 1. Create SQL for CallableStatement
			String sql = "{call GetEmployee(?)}";

			// 2. Create a CallableStatement
			callableStatement = connection.prepareCall(sql);
			
			// 2a. Insert Praamater value
			callableStatement.setInt("iempid", 5);

			// 3. Execute the CallableStatement

			resultSet = callableStatement.executeQuery();

			// 4. Process the ResultSet

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("employee_id") + " "
						+ resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(resultSet);
			Database.closeCallableStatement(callableStatement);
			Database.closeConnection(connection);
		}
	}
}
