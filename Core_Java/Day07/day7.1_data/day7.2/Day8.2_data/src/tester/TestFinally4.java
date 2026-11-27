package tester;

public class TestFinally4 {

	public static void main(String[] args) {
		System.out.println("in main...");
		try {
			System.out.println("in main() method try");
			testMe();
			System.out.println("back in main");
		}catch(Exception e) {
			System.out.println("in main catch");
			e.printStackTrace();
		}
		finally {
			System.out.println("in main's finally");
		}
		System.out.println("main over....");

	}
	
	private static void testMe() throws InterruptedException {
		try {
			System.out.println("in testMe() method try");
			String[]ss= {"aa","bb"};
			Thread.sleep(1000);   // javac forces handling checked exception
			System.out.println(ss[1]);
			boolean flag=true;
			if(flag)
				return;         // still call finally block
			System.out.println("end of testMe() try");
		}finally {
			System.out.println("in testMe() method finally");
		}
		System.out.println("testMe() over...");
	}
	
	
	// above are a nested try block  inner try in testMe method and outer in main method

}
