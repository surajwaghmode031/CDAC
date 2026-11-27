package tester;

public class Tester4 {

	public static void main(String[] args) {

		try {

			System.out.println("in main ......");

			int c = 100 / 0;
			System.out.println("result " + c);

			String s = "abcd";
			System.out.println("parsed int value " + Integer.parseInt(s));

			s = null;
			System.out.println("char at 0th index " + s.charAt(0));

		}
		// multi-catch exception handling
		catch (ArithmeticException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {

			System.out.println("Exception handled");
			System.out.println(e);
		}

		System.out.println("main over....");
	}
}