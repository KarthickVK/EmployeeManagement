package com.employeemanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.employeemanagement.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static String dbhost = "jdbc:mysql://localhost:3306/databasedb";
	private static String username = "root";
	private static String password = "Karthi33";
	private static Connection connection;

	public static Connection getConnection() {

		try {
			connection = DriverManager.getConnection(dbhost, username, password);
		} catch (Exception exception) {
			System.out.println("Cannot create database connection");
		}
		return connection;
	}

	public void createEmployee(Employee employee) {

		try {
			Connection connection = getConnection();
			Date startDate = new Date(employee.getEmployeeDateOfBirth().getTime());
			String query = "insert into employeedetails (employeeId,employeeName,employeePhoneNo,employeeSalary,employeeDateOfBirth) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeePhoneNo());
			preparedStatement.setString(4, employee.getEmployeeSalary());
			preparedStatement.setDate(5, startDate);
			preparedStatement.executeUpdate();

		} catch (Exception exception) {
			System.out.println("Data not Added");
		}
	}

	public void updateEmployee(Employee employeeDetails) {

		try {
			Connection connection = getConnection();
			String query = "update employeedetails set employeeName=?,employeePhoneNo=?,employeeSalary=?,EmployeeDateOfBirth=? where employeeId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			if (employeeDetails.getEmployeeName() != null) {
				//String query = "update employeedetails set employeeName=? where employeeId=?";
			//	PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, employeeDetails.getEmployeeName());
				preparedStatement.setString(5, employeeDetails.getEmployeeId());
				preparedStatement.executeUpdate();
			} else if (employeeDetails.getEmployeePhoneNo() != null) {
			//	String query = "update employeedetails set employeePhoneNo=? where employeeId=?";
			//	PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(2, employeeDetails.getEmployeePhoneNo());
				preparedStatement.setString(5, employeeDetails.getEmployeeId());
				preparedStatement.executeUpdate();
			} else if (employeeDetails.getEmployeeSalary() != null) {
				//String query = "update employeedetails set employeeSalary=? where employeeId=?";
				//PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(3, employeeDetails.getEmployeeSalary());
				preparedStatement.setString(5, employeeDetails.getEmployeeId());
				preparedStatement.executeUpdate();
			} else if (employeeDetails.getEmployeeDateOfBirth() != null) {
				//String query = "update employeedetails set employeeDateOfBirth=? where employeeId=?";
			//	PreparedStatement preparedStatement = connection.prepareStatement(query);
				Date startDate = new Date(employeeDetails.getEmployeeDateOfBirth().getTime());
				preparedStatement.setDate(4, startDate);
				preparedStatement.setString(5, employeeDetails.getEmployeeId());
				preparedStatement.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("Record not Updated");
		}

	}

	public void deleteEmployee(String employeeId) {
		try {
			Connection connection = getConnection();
			String query = "delete from employeedetails where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employeeId);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception exception) {
			System.out.println("Data not Deleted");
		}
	}

	public void showAllEmployee() {
		try {
			Map<String, Employee> map = new HashMap<>();

			Connection connection = getConnection();
			Statement preparedStatement = connection.createStatement();
			String query = "select * from employeedetails";
			ResultSet resultSet = preparedStatement.executeQuery(query);

			while (resultSet.next()) {
				String employeeId = resultSet.getString("employeeId");
				String employeeName = resultSet.getString("employeeName");
				String employeePhoneNo = resultSet.getString("employeePhoneNo");
				String employeeSalary = resultSet.getString("employeeSalary");
				Date employeeDateOfBirth = resultSet.getDate("employeeDateOfBirth");
				Employee employee = new Employee(employeeId, employeeName, employeePhoneNo, employeeSalary,
						employeeDateOfBirth);

				map.put(employee.getEmployeeId(), employee);
			}
			System.out.println(map);
		} catch (Exception e) {
			System.out.println("Data not Show");
		}
	}
}
