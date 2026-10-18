package string;

import java.util.Scanner;

public class PalindromeWithoutRevirse {
	
	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to check palindrome :");
			String str = sc.next();
			int left=0;
			int right=str.length()-1;
			boolean isPalindrome=true;
			
			while(left<right) {
				if(str.charAt(left)!=str.charAt(right)) {
					isPalindrome=false;
				}
				left++;
				right--;
			}
			if(isPalindrome) {
				System.out.println("Palindrome");
			}else {
				System.out.println("Not Palindrome");
			}
		}
	}

}
