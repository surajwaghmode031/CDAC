package p2;

import p1.A;

// different package subclass
public class D extends A{

	public D() {
		//System.out.println("state of B:"+i+" "+j+" "+k+" "+l); // javac err for i :  private data member accessible with in same class
		                                                    // javac err for j :  default member accessible with in same package
		                    // protected K : protected member accessible outside package in subclass
	}
	

}
