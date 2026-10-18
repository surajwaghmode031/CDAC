package string;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to Recerse:");
			String str = sc.next();
			// create empty string
			String reverse=""; 
			
			for(int i=str.length()-1;i>=0;i--) {
				reverse +=str.charAt(i);
			}
			System.out.println("reversed:"+reverse);
		}

	}

}
