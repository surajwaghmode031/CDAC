package Tester;
// equals method


/*
 Create a class Vehicle, under the package com.app.vehicles, to represent any vehicle. 
 tight encapsulation state(data members): registration No: int, color: String, price: double 
 registration No MUST be unique (non duplicate) for any vehicle (primary Key: unique ID Get complete state.
Create a class TestVehicle under the package "tester" Display "SAME" or "DIFFERENT", in case of same or different reg nos.
 */
import java.util.Scanner;

import com.app.vehicles.Vehicle;

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
		System.out.println(vehicle1.equals(vehicle2));  // it call overridden equals method : from Vehicle class
		                                                // o/p : true : if both have same regNo
		
		System.out.println(vehicle1.equals(sc));  // o/p : false
		
		
		//Display "SAME" or "DIFFERENT", in case of same or different reg nos.
		
		System.out.println("Display \"SAME\" or \"DIFFERENT\", in case of same or different reg nos.");
		boolean equality=vehicle1.equals(vehicle2);
		if(equality) {
			System.out.println("SAME");
		}else {
			System.out.println("DIFFERENT");
		}
		
		// 
		sc.close();

	}

}
