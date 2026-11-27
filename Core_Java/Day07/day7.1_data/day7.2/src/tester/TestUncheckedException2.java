package tester;

public class TestUncheckedException2 {
	public static void main(String[] args) {
		String s= "123abc";
		System.out.println(Double.parseDouble(s));  // err : unchecked exception: abort code : NumberFormatException
		System.out.println("code continues.....");

	}

}
