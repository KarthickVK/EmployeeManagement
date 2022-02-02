package com.employeemanagement.service;

import com.employeemanagement.dao.EmployeeDao;
import com.employeemanagement.dao.EmployeeDaoImpl;
import com.employeemanagement.model.Employee;

/**
 * <h1>EmployeeServiceImplVersion2</h1>
 * 
 * @author KarthickV
 */
public class EmployeeServiceImplVersion2 {
	private static final EmployeeDao EMPLOYEE_DAO = new EmployeeDaoImpl();

	public void createEmployee(Employee employee) {
		EMPLOYEE_DAO.createEmployee(employee);
	}

	public void updateEmployee(Employee employeeDetails) {
		EMPLOYEE_DAO.updateEmployee(employeeDetails);
	}

	public void deleteEmployee(String employeeId) {
		EMPLOYEE_DAO.deleteEmployee(employeeId);
	}

	public void showAllEmployee() {
		System.out.println(EMPLOYEE_DAO.getAllEmployee());
	}

}
