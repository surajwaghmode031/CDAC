package com.core;

public class Student extends Person{
    private int studentId;
    private char grade;
    public static int idcounter;
    
    static {
    	idcounter=100;
    }

	public Student(String name, String surname, char grade) {
		super(name, surname);
		this.studentId = ++idcounter;
		this.grade = grade;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + super.toString() +", grade=" + grade +  "]";
	}

	
    
}
