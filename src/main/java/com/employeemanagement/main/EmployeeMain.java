package com.employeemanagement.main;

import java.util.Date;
import java.util.Scanner;

import com.employeemanagement.controller.EmployeeController;
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
	public static EmployeeController employeeController = new EmployeeController();

	/**
	 * Which makes use of create,update,delete and show the employeeDetail.
	 * 
	 * @param args unused.
	 * @return nothing.\
	 */

	public static void main(String[] args) {
		String userChoice;

		do {
			System.out.println("a.CREATE \nb.UPDATE \nc.DELETE \nd.SHOW \nEnter your choice");
			String choice = SCANNER.nextLine();

			if ("a".equals(choice)) {
				createEmployee();
			} else if ("b".equals(choice)) {
				updateEmployee();
			} else if ("c".equals(choice)) {
				deleteEmployee();
			} else if ("d".equals(choice)) {
				showAllEmployee();
			}
			System.out.println("Do you need to Continue?");
			userChoice = SCANNER.nextLine();
		} while ("y".equals(userChoice) || "Y".equals(userChoice));
	}

	/**
	 * Collect all the user input to stored the separated variables.
	 */

	private static void createEmployee() {
		String employeeId = EmployeeView.getEmployeeId();
		String employeeName = EmployeeView.getEmployeeName();
		String employeePhoneNo = EmployeeView.getEmployeePhoneNo();
		String salary = EmployeeView.getEmployeeSalary();
		Date employeeDateOfBirth = EmployeeView.getEmployeeDateOfBirth();
		Employee employee = new Employee(employeeId, employeeName, employeePhoneNo, salary, employeeDateOfBirth);

		employeeController.createEmployee(employeeId, employee);
	}

	/**
	 * Update EmployeeDetails. Then which detail are updated to user to choice any
	 * one properties. Then user choose the one properties to call the related
	 * method.
	 */

	private static void updateEmployee() {
		String choice = EmployeeView.chooseChoice();

		if ("a".equals(choice)) {
			updateEmployeeName();
		} else if ("b".equals(choice)) {
			updateEmployeePhoneNo();
		} else if ("c".equals(choice)) {
			updateEmployeeSalary();
		} else if ("d".equals(choice)) {
			updateEmployeeDateOfBirth();
		}
	}

	/**
	 * User choose update the employeeName then call this method.
	 */

	private static void updateEmployeeName() {
		String employeeId = EmployeeView.getEmployeeId();
		String employeeName = EmployeeView.getEmployeeName();
		Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeName(employeeName);
		employeeController.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * User choose update the employeeDateOfBirth then call this method.
	 */

	private static void updateEmployeeDateOfBirth() {
		String employeeId = EmployeeView.getEmployeeId();
		Date employeeDateOfBirth = EmployeeView.getEmployeeDateOfBirth();
		Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeDateOfBirth(employeeDateOfBirth);
		employeeController.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * User choose update the employeeSalary then call this method.
	 */

	private static void updateEmployeeSalary() {
		String employeeId = EmployeeView.getEmployeeId();
		String salary = EmployeeView.getEmployeeSalary();
		Employee employeeDetails = new Employee();

		employeeDetails.setEmployeeSalary(salary);
		employeeController.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * User choose update the employeePhoneno then call this method.
	 */

	private static void updateEmployeePhoneNo() {
		String employeeId = EmployeeView.getEmployeeId();
		String employeePhoneNo = EmployeeView.getEmployeePhoneNo();
		Employee employeeDetails = new Employee();

		employeeDetails.setEmployeePhoneNo(employeePhoneNo);
		employeeController.updateEmployee(employeeId, employeeDetails);
	}

	/**
	 * Need to user which employeeDetail are delete. then to collect the key to
	 * user. then this method is passed to controller class.
	 */

	private static void deleteEmployee() {
		String employeeId = EmployeeView.getEmployeeId();

		employeeController.deleteEmployee(employeeId);
	}

	/**
	 * Show all the employeeDetails.
	 */

	private static void showAllEmployee() {
		employeeController.showAllEmployee();
	}
}
