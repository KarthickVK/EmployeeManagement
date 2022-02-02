package com.employeemanagement.service;

import java.util.Date;

import com.employeemanagement.exception.InvalidIdException;
import com.employeemanagement.model.Employee;

/**
 * <h1>EmployeeService</h1> Then only in a method declaration not implementation
 * in thin part.
 * 
 * @author KarthickV
 */
public interface EmployeeService {
	void createEmployee(Employee employee);

	void updateEmployee(Employee employeeDetails) throws InvalidIdException;

	void deleteEmployee(String employeeId) throws InvalidIdException;

	void showAllEmployee();

	String validateEmployeeName(String employeeName);

	String validateEmployeePhoneNo(String employeePhoneNo);

	Date validateEmployeeDateOfBirth(String employeeDateOfBirth);
}
