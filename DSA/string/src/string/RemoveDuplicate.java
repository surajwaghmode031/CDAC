package string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to remove duplicate :");
			String str = sc.next();
			
			Set<Character> set= new LinkedHashSet<>();
			
			for(char ch : str.toCharArray()) {
				set.add(ch);
			}
			// to print as string we need to create StringBoilder 
			StringBuilder result= new StringBuilder();
			for(char ch: set) {
				result.append(ch);
			}
			System.out.println("result : "+result);
		}

	}

}
