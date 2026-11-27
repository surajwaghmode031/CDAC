package tester;

public class Tester1 {
//	public static void main(String[] args) {
//		System.out.println("in main ......");
//		int c = 100 / 0;
//		System.out.println("result " + c); //ArithmeticException
//		String s = "abcd";
//		System.out.println("parsed int value " + Integer.parseInt(s));//NumberFormatException
//		s = null;
//		System.out.println("char at Oth index " + s.charAt(0));// NullPointerException
//		int[] data = { 1, 2, 3, 4, 5 };
//		System.out.println("array data " + data[5]); // ArrayIndexOutOfBoundsException
//		System.out.println("main over...."); 
//		 
//		// above there are multiple exception  : all are unchecked exception 
//	}
	
	public static void main(String[] args) {
		try {
		System.out.println("in main ......");
		int c = 100 / 0;
		System.out.println("result " + c); //ArithmeticException
		String s = "abcd";
		System.out.println("parsed int value " + Integer.parseInt(s));//NumberFormatException
		s = null;
		System.out.println("char at Oth index " + s.charAt(0));// NullPointerException
		int[] data = { 1, 2, 3, 4, 5 };
		System.out.println("array data " + data[5]); // ArrayIndexOutOfBoundsException
		System.out.println("End of try ....");
		}catch(ArithmeticException e) {
			System.out.println("100 / 0 err ");
		}
		System.out.println("main over...."); 
		 
		// above there are multiple exception  : all are unchecked exception 
	}

}