package Tester;

import static Utils.ValidationRules.validateSpeed;

import java.util.Scanner;

import custom_exceptions.SpeedOutOfRangeException;;
public class TestCustomERxception2 {

	public static void main(String[] args) {
		 // exception handled in main using try catch
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter speed");
			validateSpeed(sc.nextInt());
			System.out.println("End of try ...");
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("End of main");

	}

}
