package tester;

public class TestCheckedException3 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Before");
		Thread.sleep(5000);    // raised checked exception : we need to handle it : java compiler  force to handle checked exception
		                       // we can handle checked exception in two way : 1. using try-catch 2. using throws 
		                       // throws : We can delegate the exception handling responsibility to the caller method. : here is main Thread is caller
		System.out.println("After");

	}
}

