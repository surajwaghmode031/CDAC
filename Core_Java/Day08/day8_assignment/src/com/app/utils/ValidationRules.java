

package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.date.Employee;
import com.app.exception.EmployeeHandlingException;

public class ValidationRules {

	// valid departments
	public static final String DEPTS = "RnD Finance Marketing HR";

	
	// validate employee name
	public static void validateName(String name, String msg) throws EmployeeHandlingException {
		if (name.length() < 4 || name.length() > 15) {
			throw new EmployeeHandlingException(msg + " name must contain 4 to 15 characters");
		}
	}

	
	
	// validate email
	public static void validateEmail(String email) throws EmployeeHandlingException {
		if (!email.contains("@") && !email.contains(".com")) {
			throw new EmployeeHandlingException("Invalid email");
		}
	}

	
	
	
	// validate department
	public static void validateDept(String dept) throws EmployeeHandlingException {
		if (!DEPTS.contains(dept)) {
			throw new EmployeeHandlingException("Invalid department");
		}
	}

	
	// parse and validate join date
	public static Date parseValidateJoinDate(String date) throws ParseException, EmployeeHandlingException {
		// formatter object
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// convert String -> Date
		Date joinDate = sdf.parse(date);
		// valid reference date
		Date validDate = sdf.parse("01-04-2021");

		// join date must be after valid date
		if (joinDate.after(validDate)) {
			return joinDate;
		}
		throw new EmployeeHandlingException("Join date must be after 1-Apr-2021");
	}
	
	
	

	// check duplicate emp id
	public static void validateDuplicateEmpId(Employee[] employees, Employee newEmp, int count)
			throws EmployeeHandlingException {
		for (int i = 0; i < count; i++) {
			// equals checks empId
			if (employees[i].equals(newEmp)) {
				throw new EmployeeHandlingException("Duplicate emp id not allowed");
			}
		}
	}
	
	

	// centralized validation method
	public static Employee validateAllInputs(int empId, String fn, String ln, String email, String dept, String date,
			double salary, Employee[] employees, int count) throws Exception {

		// validate first name
		validateName(fn, "First");
		
		// validate last name
		validateName(ln, "Last");

		// validate email
		validateEmail(email);

		// validate department
		validateDept(dept);

		// create employee object
		Employee newEmp = new Employee(empId, fn, ln, email, dept, parseValidateJoinDate(date), salary);

		// validate duplicate emp id
		validateDuplicateEmpId(employees, newEmp, count);

		// return validated employee object
		return newEmp;
	}
}
