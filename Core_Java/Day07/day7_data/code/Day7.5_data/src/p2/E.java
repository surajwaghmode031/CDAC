package p2;

import p1.A;

// same package , non subclass 
public class E {
	
	E(){
		A a1=new A(); 
		//System.out.println("state of C:"+a1.i+" "+a1.j+" "+a1.k+" "+a1.l); // javac err for i :  private data member accessible with in same class
                                                                        // javac err for j :  default member accessible with in same package
                                                     // javac err for K : protected member accessible outside package in subclass
	}
}
