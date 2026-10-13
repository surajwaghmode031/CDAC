package com.app.core;

public class Person {
	private String firstName,lastName;

	public Person(String firstName, String lastName) {
		System.out.println("in Person constructor");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public Person() {
		System.out.println("in person default constructor");
	}
	
	// can person class modify (override) , inherited toString method ? :yes
	@Override  // annotation -> provide metadata(information about code) : Here @Override tells the compiler: “This method is overriding a parent method”
	public String toString() {
		return firstName+" "+lastName;
	}
	
	// add getter for 1st name of person
	public String getFirstName() {
		return firstName;
	}

}
