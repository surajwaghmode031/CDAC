package p2;
//  topic multiple inheritance :  dimond problem
// in i/f A and B : same name, same method signature , different return type ->  during method overloading : return type ignored 
//  javac err : classic ambiguity -> in a class we cannot add method with same name, same method signature , different return type  -> solution i/f
public class MyImpleClass implements A, B {
	@Override
	// javac err
	public void show() {
		System.out.println("in show");
	}

	// we can not add method with same name, same method signature , different return type in a same class
	public String show(){
		return null;

}
