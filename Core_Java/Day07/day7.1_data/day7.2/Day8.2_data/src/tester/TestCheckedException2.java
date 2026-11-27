package tester;

public class TestCheckedException2 {

	public static void main(String[] args) {
		System.out.println("Before");
		try {
		Thread.sleep(5000);    // raised checked exception : we need to handle it : java compiler  force to handle checked exception
		                       // we can handle checked exception in two way : 1. using try-catch 2. using throws 
		}catch(InterruptedException e) {
			System.out.println("err occured....");
		}
		System.out.println("After");

	}
}

