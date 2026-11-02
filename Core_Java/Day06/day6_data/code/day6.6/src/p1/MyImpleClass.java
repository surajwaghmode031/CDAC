package p1;
//  topic multiple inheritance : solution of dimond problem
// same 2  method implemantation by 2 i/f -> we need to define only once in 
public class MyImpleClass implements A, B {
	@Override
	public void show() {
		System.out.println("in show");
	}

}
