package p2;


public class Tester1 {

	public static void main(String[] args) {
		
		// array holding i/f type of references  
		// upcasting
		Printable[] printables= {new ConsolePrinter(), new FilePrinter(), new NetworkPrinter()};  // array holding i/f type of references
		
		for(Printable p: printables) {
			p.print("some message...!!!");   // dynamic method dispatch
			
			if(p instanceof NetworkPrinter) {
				((NetworkPrinter)p).encrytData("mesg to be coded");
			}else {
				System.out.println(" can't encrypt data..!!!!");
			}
		}
		
				
	}

}
