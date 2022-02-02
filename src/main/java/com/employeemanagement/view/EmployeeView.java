package com.employeemanagement.view;

import java.util.Date;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.main.EmployeeMain;

/**
 * Represents on EmployeeView. this class is used to collect all the user
 * inputs.
 * 
 * @author KarthickV
 */
public class EmployeeView {

	/**
	 * Get employeeId to the user.
	 * 
	 * @return String
	 */
	public static String getEmployeeId() {
		System.out.println("Enter the employeeId:");
		return EmployeeMain.SCANNER.nextLine();
	}

	/**
	 * Get EmployeeName to the user
	 * 
	 * @return String
	 */
	public static String getEmployeeName() {
		System.out.println("Enter the employeeName:");
		return EmployeeController.validateEmployeeName(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * Get EmployeePhoneNo to the user.
	 * 
	 * @return String
	 */
	public static String getEmployeePhoneNo() {
		System.out.println("Enter the employeePhoneNo:");
		return EmployeeController.validateEmployeePhoneNo(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * Get EmployeeSalary to the user.
	 * 
	 * @return String
	 */
	public static String getEmployeeSalary() {
		System.out.println("Enter the employeeSalary:");
		return EmployeeMain.SCANNER.nextLine();
	}

	/**
	 * Get EmployeeDateOfBirth to the user.
	 */
	public static Date getEmployeeDateOfBirth() {
		System.out.println("Enter the employeeDateOfBirth(yyyy-MM-dd)");
		return EmployeeController.validateEmployeeDateOfBirth(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * Choose the choice to user. which details update to the user.
	 * 
	 * @return String
	 */
	public static String chooseChoice() {
		System.out.println(
				"a.EmployeeName \nb.EmployeePhoneNo \nc.EmployeeSalary \nd.EmployeeDateOfBirth \nEnter your choice");
		return EmployeeMain.SCANNER.nextLine();
	}
}
