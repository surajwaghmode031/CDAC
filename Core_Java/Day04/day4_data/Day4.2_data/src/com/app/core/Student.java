package com.app.core;

public class Student extends Person {
	private int graductionYear;
	private String course;
	private double fees;
	private int marks;
	private String grade;
	private String feedback;
	
	
	// add parameterized constructor to initialize complite state of a Student
	public Student(String firstName, String lastName, int graductionYear, String course, double fees, int marks) {
		super(firstName, lastName); // explicitly invoking (calling) matching immediate super class constructor , it is always 1st line in child class constructor
		System.out.println("in Student constructor");
		this.graductionYear = graductionYear;
		this.course = course;
		this.fees = fees;
		this.marks = marks;
	}
	
	//setGrade : setter
	public void setGrade(String grade) {
	    this.grade = grade;
	}

	public void setFeedback(String feedback) {
	    this.feedback = feedback;
	}
	
	
	// modifying the inherited method toString : overriding form of method
	@Override
	public String toString() {
		//super.toString() : if we not give super keyword it cause recursion
		return "Student : "+super.toString()+" graduction Year : "+graductionYear+" course : "+course+"  fees : "+ fees+" marks : "+marks+" grade : "+grade+" feedback : "+feedback;
	}
	
	// add new behavior : study
	public void study() {
		// display students fist name studying in course name
		// System.out.println(super.getFirstName()+" studying in course "+course);
		System.out.println(getFirstName()+" studying in course "+course); // getFirstName() --> implicitly :super.getFirstName()
	}

	public void submitFeedback(String facultyName, String comment) {
    System.out.println(getFirstName() + " submitted feedback.");
    System.out.println("Faculty : " + facultyName);
    System.out.println("Comment : " + comment);
}
}
