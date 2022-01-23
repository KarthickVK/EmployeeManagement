package com.employeemanagement.view;

import java.util.Date;

import com.employeemanagement.main.EmployeeMain;
import com.employeemanagement.service.EmployeeServiceImpl;

/**
 * represents on EmployeeView. this class is used to collect all the user
 * inputs.
 * 
 * @author KarthickV
 */

public class EmployeeView {

	/**
	 * this method used to get employeeId to the user.
	 * 
	 * @return String
	 */
	
	public static String getEmployeeId() {
		System.out.println("Enter the employeeId:");
		return EmployeeMain.SCANNER.nextLine();
	}

	/**
	 * this method used to get EmployeeName to the user
	 * 
	 * @return String
	 */
	
	public static String getEmployeeName() {
		System.out.println("Enter the employeeName:");
		return EmployeeServiceImpl.validateEmployeeName(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * this method used to get EmployeePhoneNo to the user.
	 * 
	 * @return String
	 */

	public static String getEmployeePhoneNo() {
		System.out.println("Enter the employeePhoneNo:");
		return EmployeeServiceImpl.validatePhoneNo(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * this method used to get EmployeeSalary to the user.
	 * 
	 * @return String
	 */

	public static String getEmployeeSalary() {
		System.out.println("Enter the employeeSalary:");
		return EmployeeMain.SCANNER.nextLine();
	}

	/**
	 * this method used to get EmployeeDateOfBirth to the user.
	 */
	
	public static Date getEmployeeDateOfBirth() {
		System.out.println("Enter the employeeDateOfBirth(yyyy-MM-dd)");
		return EmployeeServiceImpl.validateDate(EmployeeMain.SCANNER.nextLine());
	}

	/**
	 * this method used to choose the choice to user. which details update to the
	 * user.
	 * 
	 * @return String
	 */
	
	public static String choiceUpdate() {
		System.out.println(
				"a.EmployeeName \nb.EmployeePhoneNo \nc.EmployeeSalary \nd.EmployeeDateOfBirth \nEnter your choice");
		return EmployeeMain.SCANNER.nextLine();

	}

}
