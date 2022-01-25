package com.employeemanagement.service;

import java.util.Date;

import com.employeemanagement.model.Employee;

/**
 * This is a interface then the interface is accepted the controller request.
 * Then only in a method declaration not implementation in thin part.
 * 
 * @author KarthickV
 */

public interface EmployeeService {
	public void createEmployee(String employeeId, Employee employee);

	public void updateEmployee(String employeeId, Employee employeeDetails);

	public void deleteEmployee(String employeeId);

	public void showAllEmployee();
	
	public  String validateEmployeeName(String employeeName); 
	
	public String validateEmployeePhoneNo(String employeePhoneNo);
	
	public Date validateEmployeeDateOfBirth(String employeeDateOfBirth);
}
