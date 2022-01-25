package com.employeemanagement.controller;

import java.util.Date;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.service.EmployeeServiceImpl;
import com.employeemanagement.view.EmployeeView;

/**
 * <h1>EmployeeController</h1> This class is used to Control all the request and
 * response. Then controller collect the all the user details . then the details
 * are transfer to service interface. then the service response is collected and
 * transfer the user view page.
 * 
 * @author KarthickV
 */

public class EmployeeController {
	private static  EmployeeService employeeService = new EmployeeServiceImpl();
	
	/**
	 * carry all the user inputs to pass the service part.
	 * 
	 * @param employeeId the employee's employeeId(key).
	 * @param employee   the employee's details are stored in this part.
	 */

	public void createEmployee(String employeeId, Employee employee) {
		employeeService.createEmployee(employeeId, employee);
	}

	/**
	 * carry all the user inputs to pass the service part.
	 * 
	 * @param employeeId      the employee's employeeId(key).
	 * @param employeeDetails
	 */

	public void updateEmployee(String employeeId, Employee employeeDetails) {
		employeeService.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * pass the values to service part.
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
	
	/**
	 * User input is passed to service part.
	 * 
	 * @param employeeName
	 */
	
	public static String validateEmployeeName(String employeeName) {
		return employeeService.validateEmployeeName(employeeName);
	}
	
	/**
	 * User input is passed to service.
	 * @param employeePhoneNo
	 */
	
	public static String validateEmployeePhoneNo(String employeePhoneNo) {
		 return employeeService.validateEmployeePhoneNo(employeePhoneNo);
	}
	
	/**
	 * User input is passed to service.
	 * @param employeeDateOfBirth
	 */
	
	public static Date validateEmployeeDateOfBirth(String employeeDateOfBirth) {
		return employeeService.validateEmployeeDateOfBirth(employeeDateOfBirth);
 	}
	
	/**
	 * EmployeeName not match to return view page call.
	 */
	
	public static String backValidateEmployeeName() {
		return EmployeeView.getEmployeeName();
	}
	
	/**
	 * EmployeeName not match to return view page call.
	 */
	
	public static String backValidateEmployeePhoneNo() {
		return EmployeeView.getEmployeePhoneNo();
	}

	/**
	 * EmployeeName not match to return view page call.
	 */

	public static Date backValidateEmployeeDateOfBirth() {
		return EmployeeView.getEmployeeDateOfBirth();
	}
}
