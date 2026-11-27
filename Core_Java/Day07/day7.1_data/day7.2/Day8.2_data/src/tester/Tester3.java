package tester;

public class Tester3 {

	public static void main(String[] args) {

		try {

			System.out.println("in main ......");

			int c = 100 / 10;
			System.out.println("result " + c);

			String s = "abcd";
			System.out.println("parsed int value " + Integer.parseInt(s));

			s = null;
			System.out.println("char at 0th index " + s.charAt(0));

			int[] data = { 1, 2, 3, 4, 5 };
			System.out.println("array data " + data[5]);

			System.out.println("End of try ....");

		}

		catch (Exception e) { // catch all block
			System.out.println("Exception handled ( catch-all)");
			System.out.println("using getMessage()");
			System.out.println(e.getMessage()); // getMessage(): returns detail error message of exception
			System.out.println("using toString()");
			System.out.println(e); // e internally e.toString() : return name of error and detail error message
			System.out.println("using printStackTrace()");
			e.printStackTrace(); // printStackTrace()) : return name of error,detail error message and location of error
			
		}

		// Finally block always called if exception occurs or not
		// code witch want to always run that write in finally block
		finally { 

			System.out.println("inside finally block");

		}

		System.out.println("main over....");
	}
}