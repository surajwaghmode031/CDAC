package inheritance;

public class C extends B{
	public C() {
		//super(); // java compiler implicitly add super() => to call immediate super class constructor
		System.out.println("in C's ctor");
	}
}
