package com.app.students;

public class Student1 {
	private int rollNo;
	private String subject;
	private String firstName;
	private String lastName;
	private double gpa;  // grade point average
	
	
	public Student1(int rollNo, String subject, String firstName, String lastName, double gpa) {
		super();
		this.rollNo = rollNo;
		this.subject = subject;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", subject=" + subject + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gpa=" + gpa + "]";
	}
	
	
	

}
