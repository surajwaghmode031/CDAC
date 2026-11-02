package p2;


public class FilePrinter implements Printable {
	// must implement , inherited abstract functionality
	

	@Override
	public void print(String msg) {
		System.out.println(" Storing " +msg +"in the file.");
		
	}

}
