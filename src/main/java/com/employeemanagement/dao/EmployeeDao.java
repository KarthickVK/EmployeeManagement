package com.employeemanagement.dao;

import java.util.List;

import com.employeemanagement.model.Employee;

/**
 * <h1>EmployeeDao</h1>
 * Employee Data Object.
 * 
 * @author KarthickV
 */
public interface EmployeeDao {

	void createEmployee(Employee employee);

	void updateEmployee(Employee employeeDetails);

	void deleteEmployee(String employeeId);

    List<String> getAllEmployee();
}
