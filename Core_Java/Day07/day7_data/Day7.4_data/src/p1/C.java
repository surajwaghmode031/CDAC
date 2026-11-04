package p1;
// same package , non subclass 
public class C {
	
	C(){
		A a1=new A(); 
		//System.out.println("state of C:"+a1.i+" "+a1.j+" "+a1.k+" "+a1.l); // javac err for i :  private data member accessible with in same class
		                                                 // protected work : because we are in same package
	}

}
