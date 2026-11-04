package com.app.vehicles;
// equals method


/*
 Create a class Vehicle, under the package com.app.vehicles, to represent any vehicle. 
 tight encapsulation state(data members): registration No: int, color: String, price: double 
 registration No MUST be unique (non duplicate) for any vehicle (primary Key: unique ID Get complete state.
Create a class TestVehicle under the package "tester" Display "SAME" or "DIFFERENT", in case of same or different reg nos.
 */
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter 1st vehicle details:");
		System.out.println("enter regNo:");
		int regNo=sc.nextInt();
		System.out.println("enter colour:");
		String colour=sc.next();
		System.out.println("enter price:");
		double price =sc.nextDouble();
		
		Vehicle vehicle1= new Vehicle(regNo, colour, price);
		
		System.out.println("enter 2nd vehicle details:");
		System.out.println("enter regNo:");
		int regNo1=sc.nextInt();
		System.out.println("enter colour:");
		String colour1=sc.next();
		System.out.println("enter price:");
		double price1 =sc.nextDouble();
		
		Vehicle vehicle2= new Vehicle(regNo1, colour1, price1);
		
		// test equlity of 2 vehicles
		System.out.println("test equlity of 2 vehicles : ");
		System.out.println(vehicle1.equals(vehicle2));  // using inherited from of equals method : based upon reference equality
		                                                // o/p : false : both refer different object(if we have same content
		
		// hashCode() method : method to display internal representation of address
		System.out.println(" internal representation of address");
		System.out.println(vehicle1.hashCode());
		System.out.println(vehicle2.hashCode());   // both have different address
		
		System.out.println("using == (vehicle1==vehicle2)"+(vehicle1==vehicle2));
		
		
		sc.close();

	}

}
