package com.employeemanagement.main;

import java.util.Date;
import java.util.Scanner;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.exception.InvalidIdException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.view.EmployeeView;

/**
 * <h1>EmployeeManagement</h1> The EmployeeMain program implements an
 * application that that simply use CRUD operation for EmployeeManagement
 * 
 * @author KarthickV
 */
public class EmployeeMain {
	public static final Scanner SCANNER = new Scanner(System.in);
	private static final EmployeeController EMPLOYEE_CONTROLLER = new EmployeeController();

	/**
	 * Which makes use of create,update,delete and show the employeeDetail.
	 * 
	 * @param args unused.
	 * @return nothing.\
	 * @throws InvalidIdException
	 */
	public static void main(String[] args) {
		String userChoice;

		do {
			System.out.println("a.CREATE \nb.UPDATE \nc.DELETE \nd.SHOW \nEnter your choice");
			final String choice = SCANNER.nextLine();

			if ("a".equalsIgnoreCase(choice)) {
				createEmployee();
			} else if ("b".equalsIgnoreCase(choice)) {
				updateEmployee();
			} else if ("c".equalsIgnoreCase(choice)) {
				deleteEmployee();
			} else if ("d".equalsIgnoreCase(choice)) {
				getAllEmployee();
			}
			System.out.println("Do you need to Continue?");
			userChoice = SCANNER.nextLine();
		} while ("y".equalsIgnoreCase(userChoice));
	}

	/**
	 * Collect all the user input to stored the separated variables.
	 */
	private static void createEmployee() {
		final String employeeId = EmployeeView.getEmployeeId();
		final String employeeName = EmployeeView.getEmployeeName();
		final String employeePhoneNo = EmployeeView.getEmployeePhoneNo();
		final String salary = EmployeeView.getEmployeeSalary();
		final Date employeeDateOfBirth = EmployeeView.getEmployeeDateOfBirth();
		final Employee employee = new Employee(employeeId, employeeName, employeePhoneNo, salary, employeeDateOfBirth);

		EMPLOYEE_CONTROLLER.createEmployee(employee);
	}

	/**
	 * Update EmployeeDetails.Then user choose the one properties to call the related
	 * method.
	 * 
	 * @throws InvalidIdException
	 */
	private static void updateEmployee() {
		final String choice = EmployeeView.chooseChoice();

		if ("a".equalsIgnoreCase(choice)) {
			updateEmployeeName();
		} else if ("b".equalsIgnoreCase(choice)) {
			updateEmployeePhoneNo();
		} else if ("c".equalsIgnoreCase(choice)) {
			updateEmployeeSalary();
		} else if ("d".equalsIgnoreCase(choice)) {
			updateEmployeeDateOfBirth();
		}
	}

	/**
	 * Update employeeName.
	 * 
	 * @throws InvalidIdException
	 */
	private static void updateEmployeeName() {
		final String employeeId = EmployeeView.getEmployeeId();
		final String employeeName = EmployeeView.getEmployeeName();
		final Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeId(employeeId);
		employeeDetails.setEmployeeName(employeeName);

		try {
			EMPLOYEE_CONTROLLER.updateEmployee(employeeDetails);
		} catch (InvalidIdException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update employeeDateOfBirth.
	 * 
	 * @throws InvalidIdException
	 */
	private static void updateEmployeeDateOfBirth() {
		final String employeeId = EmployeeView.getEmployeeId();
		final Date employeeDateOfBirth = EmployeeView.getEmployeeDateOfBirth();
		final Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeId(employeeId);
		employeeDetails.setEmployeeDateOfBirth(employeeDateOfBirth);

		try {
			EMPLOYEE_CONTROLLER.updateEmployee(employeeDetails);
		} catch (InvalidIdException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update employeeSalary.
	 * 
	 * @throws InvalidIdException
	 */
	private static void updateEmployeeSalary() {
		final String employeeId = EmployeeView.getEmployeeId();
		final String salary = EmployeeView.getEmployeeSalary();
		final Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeId(employeeId);
		employeeDetails.setEmployeeSalary(salary);

		try {
			EMPLOYEE_CONTROLLER.updateEmployee(employeeDetails);
		} catch (InvalidIdException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update employeePhoneNo.
	 * 
	 * @throws InvalidIdException
	 */
	private static void updateEmployeePhoneNo() {
		final String employeeId = EmployeeView.getEmployeeId();
		final String employeePhoneNo = EmployeeView.getEmployeePhoneNo();
		final Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeId(employeeId);
		employeeDetails.setEmployeePhoneNo(employeePhoneNo);

		try {
			EMPLOYEE_CONTROLLER.updateEmployee(employeeDetails);
		} catch (InvalidIdException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Delete employeeDetail. 
	 *  
	 * @throws InvalidIdException
	 */
	private static void deleteEmployee() {
		final String employeeId = EmployeeView.getEmployeeId();

		try {
			EMPLOYEE_CONTROLLER.deleteEmployee(employeeId);
		} catch (InvalidIdException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Show all the employeeDetails.
	 */
	private static void getAllEmployee() {
		EMPLOYEE_CONTROLLER.getAllEmployee();
	}
}
