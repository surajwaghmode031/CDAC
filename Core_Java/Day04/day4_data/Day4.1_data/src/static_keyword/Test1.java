package static_keyword;

// static import : can directly use all static members from the specific class
import static java.lang.Math.*;

public class Test1 {
	
	// static data member 
	public static int testData; // by default initialized
	public static int testData2=4567;
	public static int testData3=1234;
	public static int testData4;
	
	
	
	// static initializer block
		// to initialize all static data members
		// block called only once at class loading time , by JVM class loader
		static {
			System.out.println("1"); 
			int a=10;
			double d=2;
			testData4=100;
		}
		// can add multiple static initializer block : Yes
		static {
			System.out.println("2");
			int c=5;
			show();
			testData4++;
		}
		
		
		//non static initializer block
		{
			System.out.println("in non static initializer block");
		}
		
		//constructor
		public Test1(double d) {
			System.out.println("in a constructor");
		}
		
		//when object of class created : 1st->non static initializer block called, 2nd->constructor called2

		
	
		
		
		
	//static method
	private static void show() { 
		System.out.println("in static show method "); 
		//static method  can not  access non static member/method directly : we need to create object of class then access
		//static method  can access static member/method directly
	}
	
	
	//non static method
	private  void display() { 
		System.out.println("in display method ");
		show();//non static method access static method directly
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("testData :"+testData);
		System.out.println("testData2 :"+testData2);
		int testData3=1020;
		System.out.println("testData3 :"+testData3);// o/p-> 1020 : 1st precedence give to local variable
		System.out.println("testData3 :"+Test1.testData3); // static data member call : className.dataMember
		
		show(); // static method call directly
		
		//Test1 t1=new Test1(); // the movement we supply parameterized constructor the default constructor gone
		Test1 t1=new Test1(10);
		t1.display(); // non static method call
		
		
		System.out.println("in main : static var  "+testData4);
		
		// use of import static
		double a=Math.sqrt(10);  // if not import or import static
		System.out.println(a);
		
		double b=sqrt(20);// if import static
		System.out.println(b);
		
		
	}

}
