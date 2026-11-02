package p1;
import static  p1.Printable.*;

public class Tester1 {

	public static void main(String[] args) {
		ConsolePrinter printer= new ConsolePrinter();
		printer.print("hello , how are you...!");
		
		// can tester(non implement) access i/f constant ? YES
		System.out.println(" interface constant :"+Printable.TEST_DATA);
		
		// Directly by importing
		System.out.println(" interface constant :"+TEST_DATA);
		
		// i/f type of reference
		Printable reference;     // memory > on stack
		
		// can create instance of i/f ? -> NO
		// reference=  new Printable(); // Cannot instantiate the type Printable
		
		reference=printer;  // no javac err -> upcastring ->  ConsolePrinter to Printable
		
		reference.print("new message .....!");  // jcm invoke : @run time : print() on which instance : ConsolePrinter ( type of object)
				
	}

}
