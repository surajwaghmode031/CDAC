package p2;

public class Tester {

	public static void main(String[] args) {
		Printable printer;
		printer= new ConsolePrinter();  // up casting
		
		printer.print("1st message");  // run time polymorphisum (Dynamic method dispatch)
		
		printer=new FilePrinter();    // up casting
		printer.print("1st message");  //  // run time polymorphisum (Dynamic method dispatch)
		
		printer=new NetworkPrinter();
		printer.print("1st message");
	}

}
