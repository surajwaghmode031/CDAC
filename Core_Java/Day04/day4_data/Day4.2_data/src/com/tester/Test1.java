package com.tester;

import com.app.core.Faculty;
import com.app.core.Person;
import com.app.core.Student; 
 public class Test1 {

public static void main(String[] args) { 
	// create student class instance
	// sub class reference pointing to sub class object : student-->student : direct referencing
	Student student1 = new Student("Rama", "Seth", 2020, "PG-DAC", 12345,75);
	System.out.println(student1.toString());// students toString is invoked
	System.out.println(student1); // implicitly : student1->student1.toString()
	System.out.println("--------------------------------");
	
	Person p; // p: super class type of reference
	p=student1; //up casting : implicit cast by javac : Student extends Person
	System.out.println(p); // implicitly : p.toString()-- javac resolved method binding by type of reference(person) : 
	                        //But JVM resolved the method binding by type of object : run time polymorphism
	
	p=new Faculty("Kiran", "Mujumdar", 10, "Java React NOSQL"); // up casting
	System.out.println(p);
	System.out.println("--------------------------------");
	
	Object o;
	o= new Student("suraj", "waghmode", 2025, "PG-DAC", 12345,67);// up casting
	System.out.println(o);
	System.out.println("--------------------------------");
	
	o=new Faculty("sourabh", "waghmode", 20, "Java React NOSQL"); // up casting
	System.out.println(o);
}
}