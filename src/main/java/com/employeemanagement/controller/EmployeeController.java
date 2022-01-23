package com.employeemanagement.controller;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.service.EmployeeServiceImpl;

/**
 * <h1>EmployeeController</h1> This class is used to Control all the request and
 * response. Then controller collect the all the user details . then the details
 * are transfer to service interface. then the service response is collected and
 * transfer the user view page.
 * 
 * @author KarthickV
 */

public class EmployeeController {
	private EmployeeService employeeService = new EmployeeServiceImpl();

	/**
	 * this method carry all the user inputs to pass the service part.
	 * 
	 * @param employeeId the employee's employeeId(key).
	 * @param employee   the employee's details are stored in this part.
	 */

	public void createEmployee(String employeeId, Employee employee) {
		employeeService.createEmployee(employeeId, employee);
	}

	/**
	 * this method carry all the user inputs to pass the service part.
	 * 
	 * @param employeeId      the employee's employeeId(key).
	 * @param employeeDetails
	 */

	public void updateEmployee(String employeeId, Employee employeeDetails) {
		employeeService.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * this method is used to pass the values to service part.
	 * 
	 * @param employeeId the employee's employeeId(key).
	 */

	public void deleteEmployee(String employeeId) {
		employeeService.deleteEmployee(employeeId);
	}

	/**
	 * all employeeDetails are passed to the service part.
	 */

	public void showAllEmployee() {
		employeeService.showAllEmployee();
	}

}
