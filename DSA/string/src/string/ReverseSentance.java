package string;

public class ReverseSentance {

	public static void main(String[] args) {
		String input= " java is awsome .";
		
		String[]word=input.trim().split("\\s+");
		
		int left=0;
		int right=word.length-1;
		
		while(left<right) {
			String temp=word[left];
			word[left]=word[right];
			word[right]=temp;
			left++;
			right--;
		}
		System.out.println(String.join(" ", word));

	}

}
