package exception_handling;

public class TestFinally1 {

	public static void main(String[] args) {
		try {                                     // outer try block
			testMe("1asdfg2345");
			System.out.println("end of try in main");
		} catch (Exception e) {
			System.out.println("in main's catch-all");
			System.out.println(e);
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over....");

	}
	static void testMe(String s) throws InterruptedException{
		System.out.println("in testMe");
		try {                                          // nested try block - inner try block
			System.out.println("Parsed int value " + Integer.parseInt(s)); //  NumberFormatException -> exception not handled -> code abort
			Thread.sleep(100);        // javac forced handle checked exception 
			System.out.println("end of meth's try");
		} finally {
			System.out.println("in method's finally");
		}
		System.out.println("end of method");
		
	}

}
