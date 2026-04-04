package com.core;

public class Faculty extends Person {
 private int facultyId;
 private String comment;
 private String FacultyName;
  private static int idcounter;
  
  static {
	  idcounter=1000;
  }

public Faculty(String name, String surname,   String facultyName) {
	super(name, surname);
	this.facultyId = ++idcounter;
	this.comment = "";
	FacultyName = facultyName;
}

public void setComment(String comment) {
	this.comment = comment;
}

public void setFacultyId(int facultyId) {
	this.facultyId = facultyId;
}

public int getFacultyId() {
	return facultyId;
}

public String getComment() {
	return comment;
}

public String getFacultyName() {
	return FacultyName;
}

@Override
public String toString() {
	return "Faculty [facultyId=" + facultyId  + super.toString() +", comment=" + comment + ", FacultyName=" + FacultyName + FacultyName+ "]";
}
  
}
