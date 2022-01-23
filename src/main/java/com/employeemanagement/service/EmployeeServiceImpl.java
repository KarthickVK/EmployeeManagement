package com.employeemanagement.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employeemanagement.main.EmployeeMain;
import com.employeemanagement.model.Employee;
import com.employeemanagement.view.EmployeeView;

/**
 * this class is implements EmployeeService interface. EmployeeService interface
 * methods are implemented in this part. in this class implementation are not
 * show in a user. Hiding a background details only show in a functionality to
 * the user.
 * 
 * @author KarthickV
 */

public class EmployeeServiceImpl implements EmployeeService {
	private final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

	/**
	 * this method is used to validate the employeeName.
	 * 
	 * @param employeeName the employee's employeeName.
	 * @return String
	 */

	public static String validateEmployeeName(String employeeName) {
		Pattern pattern = Pattern.compile("[a-zA-Z\\s]*$");
		Matcher match = pattern.matcher(employeeName);

		if (!(match.find() && match.group().equals(employeeName))) {
			System.out.println("Invalid, Please enter a valid Name");
			return EmployeeView.getEmployeeName();
		}
		return employeeName;
	}

	/**
	 * this method is used to validate the employeePhoneNo.
	 * 
	 * @param employeePhoneNo the employee's employeePhoneno
	 * @return string
	 */

	public static String validatePhoneNo(String employeePhoneNo) {
		Pattern pattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
		Matcher match = pattern.matcher(employeePhoneNo);

		if (!(match.find() && match.group().equals(employeePhoneNo))) {
			System.out.println("Please enter a valid phone number");
			return EmployeeView.getEmployeePhoneNo();
		}
		return employeePhoneNo;
	}

	/**
	 * this method is used to validate the employeeDateOfBirth.
	 * 
	 * @param employeeDateOfBirth
	 * @return Date
	 */

	public static Date validateDate(String employeeDateOfBirth) {
		try {
			LocalDate date = LocalDate.parse(employeeDateOfBirth);
			LocalDate todayDate = LocalDate.now().plusDays(1);

			if (todayDate.isAfter(date)) {
				return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			}
		} catch (Exception exception) {
			System.out.println("Date Is Invalid");
			return EmployeeView.getEmployeeDateOfBirth();
		}
		return EmployeeView.getEmployeeDateOfBirth();
	}

	/**
	 * this method used to EmployeeDetails are added to the Employee_Map. then the
	 * value is stored base on key.
	 */

	public void createEmployee(String employeeId, Employee employee) {
		EMPLOYEE_MAP.put(employeeId, employee);
	}

	/**
	 * this method used to update the employeeDetails in Employee_Map. then iterator
	 * the Employee_Map. employeeID is key .then the key based update are required.
	 * user can any details are updated.
	 */

	public void updateEmployee(String employeeId, Employee employeeDetails) {
		Iterator<String> iterator = EMPLOYEE_MAP.keySet().iterator();

		while (iterator.hasNext()) {
			String employeeKey = iterator.next();
			Employee employeeData = EMPLOYEE_MAP.get(employeeKey);

			if (employeeKey.equals(employeeId)) {

				if (employeeDetails.getEmployeeSalary() == null && employeeDetails.getEmployeePhoneNo() == null
						&& employeeDetails.getEmployeeDateOfBirth() == null) {
					employeeData.setEmployeeName(employeeDetails.getEmployeeName());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
				
				} else if (employeeDetails.getEmployeeSalary() == null && employeeDetails.getEmployeeName() == null
						&& employeeDetails.getEmployeeDateOfBirth() == null) {
					employeeData.setEmployeePhoneNo(employeeDetails.getEmployeePhoneNo());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
					
				} else if (employeeDetails.getEmployeeName() == null && employeeDetails.getEmployeePhoneNo() == null
						&& employeeDetails.getEmployeeDateOfBirth() == null) {
					employeeData.setEmployeeSalary(employeeDetails.getEmployeeSalary());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
					
				} else if (employeeDetails.getEmployeeName() == null && employeeDetails.getEmployeePhoneNo() == null
						&& employeeDetails.getEmployeeSalary() == null) {
					employeeData.setEmployeeDateOfBirth(employeeDetails.getEmployeeDateOfBirth());

					EMPLOYEE_MAP.replace(employeeId, employeeData);
					
				}
			}
		}
	}

	/**
	 * this method used to delete the selected employee details.
	 */

	public void deleteEmployee(String employeeId) {
		EMPLOYEE_MAP.remove(employeeId);
	}

	/**
	 * this method is used to show all the employee details one bye one .
	 * 
	 */

	public void showAllEmployee() {
		for (Map.Entry employeeEntry : EMPLOYEE_MAP.entrySet()) {
			System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue());
		}
	}
}
