package com.app.tester;
// equals method : with override from object class
import com.app.students.Student2;

public class TestStudentEquals2 {

	public static void main(String[] args) {
		Student2 s1 = new Student2(101,"Ract","suraj","waghmode",7.5);
		Student2 s2 = new Student2(101,"Ract","suraj","waghmode",7.5);  // Content of both student object are same
		
		System.out.println(s1.equals(s2)); // true : use override equals methods : content equality 
		
		
		Object o1 = new Student2(102,"Ract","suraj","waghmode",7.5);
		Object o2 = new Student2(102,"Ract","suraj","waghmode",7.5); // indirect referencing
		System.out.println(o1.equals(o2));  // JVM goes type of object : use override method of student2 class 
	}

}
