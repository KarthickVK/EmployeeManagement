package com.employeemanagement.controller;

import java.util.Date;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.exception.InvalidIdException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.service.EmployeeServiceImpl;
import com.employeemanagement.service.EmployeeServiceImplVersion2;
import com.employeemanagement.view.EmployeeView;

/**
 * <h1>EmployeeController</h1> This class is used to Control all the request and
 * response. Then controller collect the all the user details .
 * 
 * @author KarthickV
 */
public class EmployeeController {
	private static final EmployeeService EMPLOYEE_SERVICE = new EmployeeServiceImpl();
	private static final EmployeeServiceImplVersion2 EMPLOYEE_SERVICE_IMPL_VERSION2 = new EmployeeServiceImplVersion2();

	public void createEmployee(Employee employee) {
		EMPLOYEE_SERVICE.createEmployee(employee);
		EMPLOYEE_SERVICE_IMPL_VERSION2.createEmployee(employee);
	}

	public void updateEmployee(Employee employeeDetails) throws InvalidIdException {
		EMPLOYEE_SERVICE_IMPL_VERSION2.updateEmployee(employeeDetails);
		EMPLOYEE_SERVICE.updateEmployee(employeeDetails);
	}

	public void deleteEmployee(String employeeId) throws InvalidIdException {
		EMPLOYEE_SERVICE_IMPL_VERSION2.deleteEmployee(employeeId);
		EMPLOYEE_SERVICE.deleteEmployee(employeeId);
	}

	public void getAllEmployee() {
		EMPLOYEE_SERVICE.showAllEmployee();
		EMPLOYEE_SERVICE_IMPL_VERSION2.showAllEmployee();
	}

	public static String validateEmployeeName(String employeeName) {
		return EMPLOYEE_SERVICE.validateEmployeeName(employeeName);
	}

	public static String validateEmployeePhoneNo(String employeePhoneNo) {
		return EMPLOYEE_SERVICE.validateEmployeePhoneNo(employeePhoneNo);
	}

	public static Date validateEmployeeDateOfBirth(String employeeDateOfBirth) {
		return EMPLOYEE_SERVICE.validateEmployeeDateOfBirth(employeeDateOfBirth);
	}

	public static String returnToValidateEmployeeName() {
		return EmployeeView.getEmployeeName();
	}

	public static String returnToValidateEmployeePhoneNo() {
		return EmployeeView.getEmployeePhoneNo();
	}

	public static Date returnToValidateEmployeeDateOfBirth() {
		return EmployeeView.getEmployeeDateOfBirth();
	}
}
