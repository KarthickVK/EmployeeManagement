package com.employeemanagement.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.model.Employee;
import com.employeemanagement.view.EmployeeView;

/**
 * This class is implements EmployeeService interface. EmployeeService interface
 * methods are implemented in this part. Hiding a background details only show
 * in a functionality to the user.
 * 
 * @author KarthickV
 */

public class EmployeeServiceImpl implements EmployeeService {
	private final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();
	
	/**
	 * Validate the employeeName.
	 * 
	 * @param employeeName the employee's employeeName.
	 * @return String
	 */

	public String validateEmployeeName(String employeeName) {
		Pattern pattern = Pattern.compile("[a-zA-Z\\s]*$");
		Matcher match = pattern.matcher(employeeName);

		if (!(match.find() && match.group().equals(employeeName))) {
			System.out.println("Invalid, Please enter a valid Name");
			return EmployeeController.backValidateEmployeeName();
		}
		return employeeName;
		
	}

	/**
	 * Validate the employeePhoneNo.
	 * 
	 * @param employeePhoneNo the employee's employeePhoneno
	 * @return string
	 */

	public String validateEmployeePhoneNo(String employeePhoneNo) {
		Pattern pattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
		Matcher match = pattern.matcher(employeePhoneNo);

		if (!(match.find() && match.group().equals(employeePhoneNo))) {
			System.out.println("Please enter a valid phone number");
			return EmployeeController.backValidateEmployeePhoneNo();
		}
		return employeePhoneNo;
	}

	/**
	 * Validate the employeeDateOfBirth.
	 * 
	 * @param employeeDateOfBirth
	 * @return Date
	 */

	public Date validateEmployeeDateOfBirth(String employeeDateOfBirth) {
		try {
			LocalDate date = LocalDate.parse(employeeDateOfBirth);
			LocalDate todayDate = LocalDate.now().plusDays(1);

			if (todayDate.isAfter(date)) {
				return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			}
		} catch (Exception exception) {
			System.out.println("Date Is Invalid");
			return EmployeeController.backValidateEmployeeDateOfBirth();
		}
		return EmployeeView.getEmployeeDateOfBirth();
	}

	/**
	 * EmployeeDetails are added to the Employee_Map. 
	 */

	public void createEmployee(String employeeId, Employee employee) {
		EMPLOYEE_MAP.put(employeeId, employee);
	}

	/**
	 * Update the employeeDetails in Employee_Map.
	 */

	public void updateEmployee(String employeeId, Employee employeeDetails) {
		Employee employeeData=EMPLOYEE_MAP.get(employeeId);
		
			if (EMPLOYEE_MAP.containsKey(employeeId)) {

				if (employeeDetails.getEmployeeName() != null) {
					 employeeData.setEmployeeName(employeeDetails.getEmployeeName());
					 
					EMPLOYEE_MAP.putIfAbsent(employeeId, employeeData);
				} else if (employeeDetails.getEmployeePhoneNo() != null) {
					employeeData.setEmployeePhoneNo(employeeDetails.getEmployeePhoneNo());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
				} else if (employeeDetails.getEmployeeSalary() != null) {
					employeeData.setEmployeeSalary(employeeDetails.getEmployeeSalary());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
				} else if (employeeDetails.getEmployeeDateOfBirth() != null) {
					employeeData.setEmployeeDateOfBirth(employeeDetails.getEmployeeDateOfBirth());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
				}
				}else {
				System.out.println("Key not match");
			}
	}
	

		/**
		 * Delete the selected employee details.
		 */

		public void deleteEmployee(String employeeId) {
			if (EMPLOYEE_MAP.containsKey(employeeId)) {
				EMPLOYEE_MAP.remove(employeeId);
			} else {
				System.out.println("Key not match");
			}
	}

	/**
	 * Show all the employee details one bye one .
	 */

	public void showAllEmployee() {
		for (Map.Entry employeeEntry : EMPLOYEE_MAP.entrySet()) {
			System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue());
		}
	}
}
