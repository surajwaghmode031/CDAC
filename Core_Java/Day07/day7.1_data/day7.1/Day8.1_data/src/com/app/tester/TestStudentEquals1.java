package com.app.tester;
// equals method : with out override
import com.app.students.Student1;

public class TestStudentEquals1 {

	public static void main(String[] args) {
		Student1 s1 = new Student1(101,"Ract","suraj","waghmode",7.5);
		Student1 s2 = new Student1(101,"Ract","suraj","waghmode",7.5);  // Content of both student object are same
		
		System.out.println(s1.equals(s2)); // false

	}

}
