package com.employeemanagement.service;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.exception.InvalidIdException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.view.EmployeeView;

/**
 * <h1>EmployeeServiceImpl</h1>
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
		final Pattern pattern = Pattern.compile("[a-zA-Z\\s]*$");
		final Matcher match = pattern.matcher(employeeName);

		if (!(match.find() && match.group().equals(employeeName))) {
			System.out.println("INVALID EMPLOYEE NAME");
			return EmployeeController.returnToValidateEmployeeName();
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
		final Pattern pattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
		final Matcher match = pattern.matcher(employeePhoneNo);

		if (!(match.find() && match.group().equals(employeePhoneNo))) {
			System.out.println("INVALID PHONE NO");
			return EmployeeController.returnToValidateEmployeePhoneNo();
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
			final LocalDate date = LocalDate.parse(employeeDateOfBirth);
			final LocalDate todayDate = LocalDate.now();

			if (todayDate.plusDays(1).isAfter(date)) {
				return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			}
		} catch (Exception exception) {
			System.out.println("DATE INVALID");
			return EmployeeController.returnToValidateEmployeeDateOfBirth();
		}
		return EmployeeView.getEmployeeDateOfBirth();
	}

	/**
	 * EmployeeDetails are added to the Employee_Map.
	 */
	public void createEmployee(Employee employee) {

		if (EMPLOYEE_MAP.containsKey(employee.getEmployeeId())) {
			System.out.println("ALREADY EXIT");
		} else {
			EMPLOYEE_MAP.put(employee.getEmployeeId(), employee);
		}
	}

	/**
	 * Update the employeeDetails in Employee_Map.
	 * @throws InvalidIdException 
	 */
	public void updateEmployee(Employee employeeDetails) throws InvalidIdException {

		if (EMPLOYEE_MAP.containsKey(employeeDetails.getEmployeeId())) {
			final Employee employeeData = EMPLOYEE_MAP.get(employeeDetails.getEmployeeId());

			if (employeeDetails.getEmployeeName() != null) {
				employeeData.setEmployeeName(employeeDetails.getEmployeeName());
			} else if (employeeDetails.getEmployeePhoneNo() != null) {
				employeeData.setEmployeePhoneNo(employeeDetails.getEmployeePhoneNo());
			} else if (employeeDetails.getEmployeeSalary() != null) {
				employeeData.setEmployeeSalary(employeeDetails.getEmployeeSalary());
			} else if (employeeDetails.getEmployeeDateOfBirth() != null) {
				employeeData.setEmployeeDateOfBirth(employeeDetails.getEmployeeDateOfBirth());
			}
		} else {
			throw new InvalidIdException("ID NOT FOUND");		}
	}

	/**
	 * Delete the selected employee details.
	 * @throws InvalidIdException 
	 */
	public void deleteEmployee(String employeeId) throws InvalidIdException {

		if (EMPLOYEE_MAP.containsKey(employeeId)) {
			EMPLOYEE_MAP.remove(employeeId);
		} else {
			throw new InvalidIdException("ID NOT FOUND");
		}
	}

	/**
	 * Show all the employee details one bye one .
	 */
	public void showAllEmployee() {

		for (Entry<String, Employee> employeeEntry : EMPLOYEE_MAP.entrySet()) {
			System.out.println(employeeEntry.getKey() + " " + employeeEntry.getValue());
		}
	}
}
