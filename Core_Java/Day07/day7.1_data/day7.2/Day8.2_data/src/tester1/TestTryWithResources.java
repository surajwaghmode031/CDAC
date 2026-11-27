package tester1;

import java.util.Scanner;

public class TestTryWithResources {

	public static void main(String[] args) {
		// create scanner class instance using try-with-resources block
		
		// we can open in try any class instance witch is implements AutoCloseable
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter your complet name: ");
			System.out.println("Hello, "+sc.nextLine());
		}//JVM automatically call sc.cloase()
		System.out.println("main over....");
		
		
		// try with resource is combination of try + finally , hence above try not give javac err

	}

}
