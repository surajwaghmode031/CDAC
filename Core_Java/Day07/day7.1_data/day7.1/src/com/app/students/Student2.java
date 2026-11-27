package com.app.students;

public class Student2{
	private int rollNo;
	private String subject;
	private String firstName;
	private String lastName;
	private double gpa;  // grade point average
	
	
	public Student2(int rollNo, String subject, String firstName, String lastName, double gpa) {
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
	
	// replace reference equality by content(rollNo and subject) equality
	
	@Override
	public boolean equals(Object o) {
		System.out.println("in student2 equals");
		if(o instanceof Student2) {
			Student2 s=(Student2)o;  // down casting required because we use student specific rollNo and subject
			//return this.rollNo==s.rollNo && this.subject==s.subject; // subject is string type : String is class
			                                                         // then this.subject==s.subject this is reference equality
			
			return this.rollNo==s.rollNo && this.subject.equals(s.subject);
			                                   // in String class : object equals method is override : and change into content equality 
			
		}
		return false;
	}
}
	
	
	
