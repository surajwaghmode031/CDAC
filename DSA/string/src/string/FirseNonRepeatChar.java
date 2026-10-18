package string;

import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Scanner;

public class FirseNonRepeatChar {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)){
			System.out.println("Enter a string to find first non repeating character :");
			String str = sc.next();
			
			Map<Character, Integer> map= new LinkedHashMap<>();
			
			// count frequency
			for(char ch: str.toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0)+1);
			}
			// find first non repeating character
			for(Map.Entry<Character, Integer> entry: map.entrySet()) {
				if(entry.getValue()==1) {
					System.out.println(entry.getKey());
					return;
				}
			}
		}

	}

}
