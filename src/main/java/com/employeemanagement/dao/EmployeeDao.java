package com.employeemanagement.dao;

import com.employeemanagement.model.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee employee);

	public void updateEmployee(Employee employeeDetails);

	public void deleteEmployee(String employeeId);

	public void showAllEmployee();
}
