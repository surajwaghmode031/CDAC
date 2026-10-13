package com.tester;

import java.util.Scanner;

import com.app.core.Faculty;
import com.app.core.Person;
import com.app.core.Student;

/*
 2. Event Organizer app

Suitable data structure: array of references

Type of array: Student[] or Faculty []: wrong options correct: Person[]

Menu:

1: Register Student

2.: Register Faculty

3. Display all participant details

4: Display specific participant details    i/p : seat no

100.: Exit
*/
public class EventOrganizer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter maximum number of participants");
		Person[]participants=new Person[sc.nextInt()]; // array of references
		boolean exit=false;
		int counter=0;
		while (!exit) {
			System.out.println("-----Menu-----");
			System.out.println("1.Register Student");
			System.out.println("2.Register Faculty");
			System.out.println("3.Display detail of all participants");
			System.out.println("5. Envoke subclass specific functionality");
			System.out.println("100.: Exit");
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				//student register
				if(counter<participants.length) { //  Boundary checking
					System.out.println("Enter student details :  firstName,lastName, graductionYear, course, fees,marksS");
					participants[counter++]=new Student(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextInt());
					
				}else {
					System.out.println("Event Fulll!!!");
				}
				
				break;
				
			case 2:
				//Faculty register
				if(counter<participants.length) {  //  Boundary checking
					System.out.println("Enter faculty details :   firstName, lastName, yearOfExpercience,  subjectExperties");
					participants[counter++]=new Faculty(sc.next(),sc.next(),sc.nextInt(),sc.next());
					}else {
						System.out.println("Event Fulll!!!");
					}
				break;
				
			case 3:
				// display details of all participants : for-each
				for(Person p:participants) {
					if(p!=null)// null checking
					System.out.println(p);
				}
				
				break;
				
			case 4:
				System.out.println("enter seat number:");
				int index=sc.nextInt()-1;
				if(index>=0 && index<counter) {
					System.out.println(participants[index]);
				}else {
					System.out.println("Envalid seat number!");
				}
				break;
				
			case 5:
				System.out.println("Enter seat number");
				index=sc.nextInt()-1;
				if(index>=0 && index<counter) {
					Person p=participants[index];
					// p.study(); // javac resolved by type of reference p: person , why javac err : since there is no stdy method on person class
					// err: since

					// there is no "study" method defined in Person class

					// in order to avoid ClassCastException, MUST use instanceof checking before
					// doing
					// down casting
					
					//down casting : climbing down inheritance hierarchy(not done implicitly by javac)
					if(p instanceof Student) {
						((Student)p).study();
					}else
						((Faculty)p).teach();
				}else {
					System.out.println("Envalid seat number!");
				}
				break;
				
				
				
			case 6:
			    System.out.println("Enter faculty seat no:");
			    int fIndex = sc.nextInt() - 1;

			    System.out.println("Enter student name:");
			    String sName = sc.next();

			    System.out.println("Enter grade (A+, A, B+, B, C+, C):");
			    String grade = sc.next();

			    if (fIndex >= 0 && fIndex < counter && participants[fIndex] instanceof Faculty) {

			        Faculty faculty = (Faculty) participants[fIndex];

			        boolean found = false;

			        for (Person p : participants) {
			            if (p instanceof Student) {
			                Student s = (Student) p;

			                if (s.getFirstName().equalsIgnoreCase(sName)) {
			                    faculty.evaluateStudent(s, grade);
			                    found = true;
			                    break;
			                }
			            }
			        }

			        if (!found)
			            System.out.println("Student not found!");

			    } else {
			        System.out.println("Invalid faculty seat!");
			    }
			    break;
			    
			    
			    
			case 7:
			    System.out.println("Enter student seat no:");
			    int sIndex = sc.nextInt() - 1;

			    System.out.println("Enter faculty name:");
			    String fName = sc.next();

			    sc.nextLine(); // clear buffer
			    System.out.println("Enter feedback:");
			    String feedback = sc.nextLine();

			    if (sIndex >= 0 && sIndex < counter && participants[sIndex] instanceof Student) {

			        Student student = (Student) participants[sIndex];

			        boolean found = false;

			        for (Person p : participants) {
			            if (p instanceof Faculty) {
			                Faculty f = (Faculty) p;

			                if (f.getFirstName().equalsIgnoreCase(fName)) {
			                    student.setFeedback("For " + fName + ": " + feedback);
			                    System.out.println("Feedback submitted!");
			                    found = true;
			                    break;
			                }
			            }
			        }

			        if (!found)
			            System.out.println("Faculty not found!");

			    } else {
			        System.out.println("Invalid student seat!");
			    }
			    break;
				
			case 100:
				exit=true;
				break;
			}
			
		}
		
		sc.close();
		
	}

}
