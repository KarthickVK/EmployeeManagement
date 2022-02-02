package com.employeemanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employeemanagement.model.Employee;

/**
 * <h1>EmployeeDaoImpl</h1>
 * 
 * @author KarthickV
 */
public class EmployeeDaoImpl implements EmployeeDao {

	/**
	 * Create the mySql insert statement.
	 */
	public void createEmployee(Employee employee) {
		final String query = "insert into employeedetails (employeeId,employeeName, employeePhoneNo, employeeSalary, employeeDateOfBirth, isactive) values (?, ?, ?, ?, ?, true)";

		try (final Connection connection = ConnectDataBase.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			final Date startDate = new Date(employee.getEmployeeDateOfBirth().getTime());

			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeePhoneNo());
			preparedStatement.setString(4, employee.getEmployeeSalary());
			preparedStatement.setDate(5, startDate);

			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			System.out.println("DATA NOT INSERTED");
		}
	}

	/**
	 * Create the mySql update statement.
	 */
	public void updateEmployee(Employee employeeDetails) {
		String query = "update employeedetails set";

		try (final Connection connection = ConnectDataBase.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			if (employeeDetails.getEmployeeName() != null) {
				query = query + " employeeName = '" + employeeDetails.getEmployeeName() + "'";
			} else if (employeeDetails.getEmployeePhoneNo() != null) {
				query = query + " employeePhoneNo = '" + employeeDetails.getEmployeePhoneNo() + "'";
			} else if (employeeDetails.getEmployeeSalary() != null) {
				query = query + " employeeSalary = '" + employeeDetails.getEmployeeSalary() + "'";
			} else if (employeeDetails.getEmployeeDateOfBirth() != null) {
				Date startDate = new Date(employeeDetails.getEmployeeDateOfBirth().getTime());
				query = query + " employeeDateOfBirth = '" + startDate + "'";
			}
			query = query + "where employeeId= '" + employeeDetails.getEmployeeId() + "'";

			preparedStatement.executeUpdate(query);
		} catch (Exception exception) {
			System.out.println("DATA NOT UPDATED");
		}
	}

	/**
	 * Create the mySql delete statement.
	 */
	public void deleteEmployee(String employeeId) {
		final String query = "update employeedetails set isactive = false where employeeId = ?";

		try (final Connection connection = ConnectDataBase.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, employeeId);
			
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			System.out.println("ID NOT FOUND");
		}
	}

	/**
	 * Create the mySql select statement.
	 */
	public List<String> getAllEmployee() {
		final List<String> list = new ArrayList<String>();
		final String query = "select * from employeedetails where isactive = true";

		try (final Connection connection = ConnectDataBase.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet resultSet = statement.executeQuery(query)) {
			final ResultSetMetaData metadata = resultSet.getMetaData();
			final int count = metadata.getColumnCount();

			while (resultSet.next()) {

				for (int i = 1; i <= count; i++) {
					final String employee = resultSet.getString(i) + " ";

					list.add(employee);
				}
			}
		} catch (Exception exception) {
			System.out.println("ID NOT FOUND");
		}
		return list;
	}
}
