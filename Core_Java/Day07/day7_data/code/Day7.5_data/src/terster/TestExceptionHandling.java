package terster;

public class TestExceptionHandling {
	public static void main(String[] args) {
		int a=100;
		int b=0;
		
		System.out.println("result: "+(a/b)); // run time err: java.lang.ArithmeticException
		                            // when we don't write any exception handler(try-catch block): JVM supply default exception handler
		                            // it abort code
		System.out.println("main over");
		
	}

}
