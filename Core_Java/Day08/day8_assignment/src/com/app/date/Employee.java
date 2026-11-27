package com.app.date;

import java.util.Date;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String dept;
	private Date joinDate;
	private double salary;

	// PK Constructor
	public Employee(int empId) {
		this.empId = empId;
	}

	// All Args Constructor
	public Employee(int empId, String firstName, String lastName, String email, String dept, Date joinDate,double salary) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dept = dept;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			return this.empId == emp.empId;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dept=" + dept + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
}