package terster;

public class TestExceptionHandling1 {
	public static void main(String[] args) {
		try {
		int a=100;
		int b=0; // b=10
		
		System.out.println("result: "+(a/b));
		System.out.println("End of try.....");
		}catch(ArithmeticException e) {
			System.out.println("Exception occured!!!");
		}
		System.out.println("main over");
		
	}

}
