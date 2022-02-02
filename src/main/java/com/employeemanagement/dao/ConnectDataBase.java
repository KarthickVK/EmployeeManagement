package com.employeemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

/**
 * <h1>ConnectDataBase</h1>
 * 
 * @author KarthickV
 */
public class ConnectDataBase {
	private static final String dbhost = "jdbc:mysql://localhost:3306/databasedb";
	private static final String username = "root";
	private static final String password = "Karthi33";

	/**
	 * Create the mySql database connection
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		try {
			final Connection connection = DriverManager.getConnection(dbhost, username, password);
			return connection;
		} catch (Exception exception) {
			throw new ConnectionIsClosedException("FAILED TO CONNECTION");
		}

	}
}
