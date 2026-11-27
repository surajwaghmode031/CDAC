package tester;

public class TestCheckedException1 {

	public static void main(String[] args) {
		System.out.println("Before");
		//Thread.sleep(5000);    // raised checked exception : we need to handle it :InterruptedException 
		System.out.println("After");

	}

}
