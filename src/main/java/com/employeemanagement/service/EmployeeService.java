package com.employeemanagement.service;

import com.employeemanagement.model.Employee;

/**
 * This is a interface then the interface is accepted the controller request.
 * then only in a method declaration not implementation in thin part.
 * 
 * @author KarthickV
 */

public interface EmployeeService {

	/**
	 * this part only declaration not implemented.
	 * 
	 * @param employeeId the employees's employeeId(key).
	 * @param employee   the employee's details stored in this variables.
	 */
	public void createEmployee(String employeeId, Employee employee);

	/**
	 * this part only declaration not implemented.
	 * 
	 * @param employeeId      the employees's employeeId(key).
	 * @param employeeDetails the employee's updated details stored in this
	 *                        variables.
	 */

	public void updateEmployee(String employeeId, Employee employeeDetails);

	/**
	 * this part only declaration not implemented.
	 * 
	 * @param employeeId the employees's employeeId(key).
	 */

	public void deleteEmployee(String employeeId);

	/**
	 * this part only declaration not implemented.
	 */

	public void showAllEmployee();
}
