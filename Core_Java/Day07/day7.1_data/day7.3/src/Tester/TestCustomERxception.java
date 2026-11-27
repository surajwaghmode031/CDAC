package Tester;

import static Utils.ValidationRules.validateSpeed;

import java.util.Scanner;

import custom_exceptions.SpeedOutOfRangeException;;
public class TestCustomERxception {

	public static void main(String[] args) throws SpeedOutOfRangeException {   // exception is handling by JVM
		
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter speed");
			validateSpeed(sc.nextInt());
			System.out.println("End of try ...");
		}
		System.out.println("End of main");

	}

}
