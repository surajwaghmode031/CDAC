package string;

public class Anagram {

	public static void main(String[] args) {
		String s1="listen";
		String s2="silent";
		
		if(isAnagram(s1,s2)) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not Anagram");
		}

	}

	private static boolean isAnagram(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		int[]freq=new int[256];
		for(int i=0;i<s1.length();i++) {
			freq[s1.charAt(i)]++;
			freq[s2.charAt(i)]--;
		}
		for(int count : freq) {
			if(count!=0) {
				return false;
			}
		}
		return true;
	}

}
