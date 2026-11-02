package p2;


public class ConsolePrinter implements Printable {
	// must implement , inherited abstract functionality
	

	@Override
	public void print(String msg) {
		System.out.println(" printing" +msg +"on the consle.");
		
		// Implementation class can directly access interface constants
		System.out.println(TEST_DATA);

	}

}
