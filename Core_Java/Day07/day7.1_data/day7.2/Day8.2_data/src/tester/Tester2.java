package tester;

public class Tester2 {
	public static void main(String[] args) {

		try {

			System.out.println("in main ......");

			int c = 100 / 10;
			System.out.println("result " + c); // no  ArithmeticException

			String s = "abcd";
			System.out.println("parsed int value " + Integer.parseInt(s)); // NumberFormatException

			s = null;
			System.out.println("char at 0th index " + s.charAt(0)); // NullPointerException

			int[] data = { 1, 2, 3, 4, 5 };
			System.out.println("array data " + data[5]); // ArrayIndexOutOfBoundsException

			System.out.println("End of try ....");

		}

		catch (ArithmeticException e) {
			System.out.println("ArithmeticException handled");
		}

		catch (NumberFormatException e) {
			System.out.println("NumberFormatException handled");
		}

		catch (NullPointerException e) {
			System.out.println("NullPointerException handled");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException handled");
		}

		catch (Exception e) {  // catchAll Exception block 
			System.out.println("Generic exception handled");
		}

		System.out.println("main over....");
	}
}