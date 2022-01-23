package com.employeemanagement.model;

import java.util.Date;

/**
 * Represents an Employee.
 *
 * @author KarthickV
 
 */

public class Employee {
	private String employeeId;
	private String employeeName;
	private String employeePhoneNo;
	private String employeeSalary;
	private Date employeeDateOfBirth;
	
	/**
	 * this is a empty constructor.
	 * no arguments are passed in this constructor.
	 */

	public Employee() {
		super();
	}
	
	/**
	 * Creates an employee with the specified name.
	 * 
	 * @param employeeId   the employee's employeeId.
	 * @param employeeName the employee's employeeName.
	 * @param phoneNo      the employee's phoneNo
	 * @param salary       the employee's salary.
	 * @param dateOfBirth  the employee's dateOfBirth.
	 */

	public Employee(String employeeId,String employeeName, String employeePhoneNo, String employeeSalary, Date employeeDateOfBirth) {
		this.employeeId=employeeId;
		this.employeeName = employeeName;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeSalary = employeeSalary;
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	
	/**
	 * Gets the employee’s employeeId.
	 * @return A string representing the employee’s employeeId.
	 */
	
    public String getEmployeeId() {
	    return employeeId;
    }
    
    /**
     * Sets the employee’s employeeId.
     * @param employeeId A String containing the employee’s emploeeId.
     */

    public void setEmployeeId(String employeeId) {
	    this.employeeId = employeeId;
    }

    /**
	 * Gets the employee’s employeeName.
	 * @return A string representing the employee’s employeeName.
	 */
    
	public String getEmployeeName() {
		return employeeName;
	}
	
	 /**
     * Sets the employee’s employeeName.
     * @param employeeName A String containing the employee’s employeeName.
     */

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the employee’s employeePhoneNo.
	 * @return A string representing the employee’s employeePhoneNo.
	 */
	
	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}
	
	 /**
     * Sets the employee’s employeePhoneNo.
     * @param employeePhoneNo A String containing the employee’s employeePhoneNo.
     */

	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	/**
	 * Gets the employee’s employeeSalary.
	 * @return A string representing the employee’s employeeSalary.
	 */
	
	public String getEmployeeSalary() {
		return employeeSalary;
	}
	
	 /**
     * Sets the employee’s employeeSalary.
     * @param employeeSalary A String containing the employee’s employeeSalary.
     */

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	/**
	 * Gets the employee’s employeeDateOfBirth.
	 * @return A string representing the employee’s employeeDateOfBirth.
	 */
	
	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}
	
	 /**
     * Sets the employee’s employeeDateOfBirth.
     * @param employeeDateOfBirth A String containing the employee’s employeeDateOfBirth.
     */

	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	
	/**
	 * this method used to store all the data to String.
	 */

	public String toString() {
		return new StringBuilder().append(employeeId).append(" ").append(employeeName).append(" ").append(employeePhoneNo).append(" ").append(employeeSalary)
				.append(" ").append(employeeDateOfBirth).toString();
	}
}
