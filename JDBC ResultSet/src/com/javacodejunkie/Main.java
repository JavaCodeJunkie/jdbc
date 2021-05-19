package com.javacodejunkie;

import java.sql.Connection;
import java.sql.Date;
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
			
			statement = connection.createStatement();
			
			String sql = "SELECT id, employee_id, first_name, last_name, birth_date FROM employees";
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
//				int id = resultSet.getInt("id");
//				int employeeId = resultSet.getInt("employee_id");
//				String firstName = resultSet.getString("first_name");
//				String lastName = resultSet.getString("last_name");
//				Date birthDate = resultSet.getDate("birth_date");
				
				int id = resultSet.getInt(1);
				int employeeId = resultSet.getInt(2);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				Date birthDate = resultSet.getDate(5);
				
				System.out.println(id + " " + employeeId + " " + firstName + " " +lastName + " " + birthDate);
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			Database.closeResultSet(resultSet);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}
	}
}
