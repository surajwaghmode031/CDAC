package p1;
//  topic multiple inheritance
//  implementing duplicate data -> from two interface
public class MyImpleClass implements A, B {
	@Override
	public double compute(double a1, double b1) {
		//System.out.println(DATA); // javac err
		System.out.println(A.DATA+" "+B.DATA);
		return a1*b1;
	}
	
	

//	@Override
//	public double compute(double a, double b, double c) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
