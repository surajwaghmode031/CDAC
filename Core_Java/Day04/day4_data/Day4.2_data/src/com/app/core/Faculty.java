package com.app.core;

import com.events.core.Person;
import com.events.core.Student;

public class Faculty extends Person{
	private int yearOfExpercience;
	private  String subjectExperties;
	
	
	public Faculty(String firstName, String lastName, int yearsOfExperience, String subjectExpertise) {
		super(firstName, lastName); // explicitly invoking (calling) matching immediate super class constructor , it is always 1st line in child class constructor
		System.out.println("in Faculty constructor");
		this.yearOfExpercience = yearsOfExperience;
		this.subjectExperties = subjectExpertise;
	}
	
	// modifying the inherited method toString
	@Override
	public String toString() {
		return "faculty : "+super.toString()+"  year Of Expercience : "+ yearOfExpercience+" subject Experties :"+subjectExperties;
	}
	
	// add new functionality
	public void teach() {
		System.out.println(getFirstName()+" expert in "+subjectExperties);
	}
	
	
	
	//evaluateStudent
	public void evaluateStudent(Student s, String grade) {
	    s.setGrade(grade);
	    System.out.println(getFirstName() + " evaluated " + s.getFirstName());
	}
	
	
}
