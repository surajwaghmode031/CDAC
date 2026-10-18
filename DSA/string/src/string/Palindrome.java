package string;

import java.util.Scanner;

public class Palindrome {


	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to check Palindrone:");
			String str = sc.next();
			// create StringBuilder object for reverse
			StringBuilder reverse=new StringBuilder(str);
			reverse=reverse.reverse();
			
			if(str.equals(reverse.toString())) {
				System.out.println("Palindrome");
			}else {
				System.out.println("Not Palindrome");
			}
		}

	}

	
}
