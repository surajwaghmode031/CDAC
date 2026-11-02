package p2;


public class NetworkPrinter implements Printable {
	// must implement , inherited abstract functionality
	

	@Override
	public void print(String msg) {
		System.out.println(" sending" +msg +" from client to server.");
		

	}
	
	public void  encrytData(String message) {
		System.out.println("Encrypting the message :"+message);
	}

}
