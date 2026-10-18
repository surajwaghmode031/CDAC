package string;

import java.util.Scanner;

public class VowelsAndConsonants {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to count Vowels And Consonants :");
			String str = sc.next();
			str=str.toLowerCase();
			int vowels=0;
			int consonants=0;
			
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				if(ch>='a' && ch<='z') {
					if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
						vowels++;
					}else {
						consonants++;
					}
					
				}
			}
			System.out.println("vowels : "+vowels);
			System.out.println("consonants : "+consonants);
		}

	}

}
