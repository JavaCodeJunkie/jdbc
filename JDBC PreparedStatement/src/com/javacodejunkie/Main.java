package com.javacodejunkie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String dbUrl = "jdbc:mariadb://localhost:3306/tutorial";
		String user = "root";
		String password = "password";

		try {
			connection = Database.getConnection(dbUrl, user, password);
			System.out.println("Database connecion successful");

			// Let's Make a Plan
			// 1. Create SQL for PreparedStatement using Parameters

			String sql = "SELECT id, employee_id, first_name, last_name FROM employees WHERE id=?";

			// 2. Create a Prepared Statement

			preparedStatement = connection.prepareStatement(sql);

			// 3. Insert Parameter value(s) into PreparedStatement

			preparedStatement.setInt(1, 25);

			// 4. Execute the PreparedStatement

			resultSet = preparedStatement.executeQuery();

			// 5. Process the ResultSet (if applicable)

			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("employee_id") + " "
						+ resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(resultSet);
			Database.closePreparedStatement(preparedStatement);
			Database.closeConnection(connection);
		}
	}
}
