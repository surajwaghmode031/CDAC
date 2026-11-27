
package com.app.tester;

import java.util.Scanner;
import com.app.date.Employee;
import static com.app.utils.ValidationRules.*;

public class TestEmployee {
	public static void main(String[] args) {

		// scanner object
		Scanner sc = new Scanner(System.in);
		// array of employee references
		Employee[] employees = new Employee[100];
		// employee counter
		int count = 0;
		// loop control variable
		boolean exit = false;

		// menu driven loop
		while (!exit) {
			System.out.println("\n----- EMP MENU -----");
			System.out.println("1. Hire Employee");
			System.out.println("2. Display All Employees");
			System.out.println("3. Exit");
			System.out.print("Enter choice : ");

			int choice = sc.nextInt();
			switch (choice) {

			// hire employee
			case 1:
				try {
					System.out.print("Enter emp id : ");
					int empId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter first name : ");
					String fn = sc.nextLine();
					System.out.print("Enter last name : ");
					String ln = sc.nextLine();
					System.out.print("Enter email : ");
					String email = sc.nextLine();
					System.out.print("Enter dept (RnD, Finance, Marketing, HR): ");
					String dept = sc.nextLine();
					System.out.print("Enter join date(dd-MM-yyyy) : ");
					String date = sc.nextLine();
					System.out.print("Enter salary : ");
					double salary = sc.nextDouble();

					// validate all inputs
					Employee emp = validateAllInputs(empId, fn, ln, email, dept, date, salary, employees, count);

					// store employee
					employees[count] = emp;
					count++;
					System.out.println("Employee hired successfully");

				}

				// handle all exceptions
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			// display all employees
			case 2:
				if (count == 0) {
					System.out.println("No employees found...");
				}
				else {
					for (int i = 0; i < count; i++) {
						System.out.println(employees[i]);
					}
				}

				break;

			// exit application
			case 3:
				exit = true;
				System.out.println("Thank you...");
				break;

			// invalid choice
			default:
				System.out.println("Invalid choice...");
			}
		}

		// close scanner
		sc.close();
	}
}