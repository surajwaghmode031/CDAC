package com.tester;

import java.util.Scanner;

import com.core.Faculty;
import com.core.Person;
import com.core.Student;

public class Event0rganizer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Person[] persons= new Person [100];
		
		int index =0;
		 int choice;
		 do {
			 System.out.println("\n");
				System.out.println("1. Register Student : ");
				System.out.println("2. Register Faculty ");
				System.out.println("3. Display All Participants Details : ");
				System.out.println("4. Search Participant : ");
				System.out.println("5. Evaluate Student : ");
				System.out.println("6. Submit FeedBack : ");
				System.out.println("7.exit..!");
				System.out.println("\n");
				System.out.print("Enter the Choice : ");
				choice = sc.nextInt();
				
				switch(choice) {
              //for creating the saving account with default balance
			case 1: {
				System.out.println("Enter the FirstName : ");
				String firstName = sc.nextLine();
				sc.nextLine();
				System.out.println("Enter the Last Name : ");
				String lastName = sc.nextLine();
				System.out.println("Enter grade : ");
				char grade = sc.next().charAt(0);

				Person p = new Student(firstName,lastName,grade);
				persons[index]=p;
				index++;
				break;

				}

						
						
			case 2: {

				System.out.println("Enter the FacultyName: ");
				String facName = sc.nextLine();

				sc.nextLine();

				System.out.println("Enter the FirstName : ");
				String firstName = sc.nextLine();

				System.out.println("Enter the Last Name : ");
				String lastName = sc.nextLine();

				Person p = new Faculty(firstName, lastName, facName);
				persons[index] = p;
				index++;

				break;
			}

						
						
			case 3:{
				if(index==0) {
					System.out.println("theier is no person detail to display");
					break;
				}
				  for(Person p : persons ) {
					  if(p!=null)
						  System.out.println(p.toString());
				  }
				  break;
				}
				

						
			case 4:{
				if(index==0) {
					System.out.println("theier is no person detail to display");
					break;
				}
				System.out.println("Enter the Id to Search : ");
				int id = sc.nextInt();
				boolean found = false;
				for(Person p: persons) {
					if(p!=null) {
						if(p instanceof Student) {
							Student s = (Student)p;
							if(s.getStudentId()==id) {
								found = true;
								System.out.println("participate Student is found "+s.toString());
								break;
							}
						}
					if(p instanceof Faculty) {
						Faculty f= (Faculty)p;
						if(f.getFacultyId()==id) {
							found = true;
							System.out.println("particapate faculty is found "+f.toString());
							break;
						}
					}
					}
				}
				if(!found) {
					System.out.println("Participants not Found ");
				}
				break;
			}


						
			//Evaluate Student 
			case 5:{
				if(index==0) {
					System.out.println("theier is no student to  Evaluate Student ");
					break;
				}
				System.out.print("Enter Student ID to evaluate: ");
				int id = sc.nextInt();
				System.out.print("EnterGrade): ");
				char grade = sc.next().charAt(0);    //charAt(index) returns the character at the specified index.
				                                     // Why is it used in your program? -> - sc.next() reads "A" as a String.
                                                                                          //- .charAt(0) extracts 'A' as a char.
                                                                                          // - grade stores the character 'A'.
                                                  // This is useful because your setGrade() method accepts a char parameter.
				boolean found = false;
				
				for(Person p : persons) {
						if(p instanceof Student) {
						Student s = (Student)p;
						if(s.getStudentId()==id) {
							s.setGrade(grade);
							System.out.println("Evaluation recorded: " + s.toString());
						    found = true;
							break;
						}
						}	
					}
				if(!found){
							System.out.println("Participants not Found ");
						}
					break;
				}

						
				
				case 6:{
					if(index==0) {
					System.out.println("theier is no student to  Submit FeedBack ");
					break;
				}
					System.out.print("Enter Student ID to send feedback: ");
					int id = sc.nextInt();
					System.out.print("Enter faculty ID and name : ");
					int id1 = sc.nextInt();
					String fname= sc.nextLine();
					
					boolean found = false;
					
					for(Person p: persons ) {
						if ( p instanceof Faculty) {
							Faculty f = (Faculty)p;
							if(f.getFacultyId()==id1) {
							String s ="1.Excellent teaching skills and very approachable. \n"
										+ " 2.Provides clear explanations and makes complex topics easy to understand.\n"
										+"   3.Engaging lectures and encourages student participation.";
								f.setComment(s);
								System.out.println( f.toString());
								found=true;
							}
						}
					}
					if(!found){
							System.out.println("Participants not Found ");
					}
					break;
				}

						
				case 7:{
					System.out.println("Exit......!");
				}
				}
			 
		 }while(choice!=7);
	}
}
