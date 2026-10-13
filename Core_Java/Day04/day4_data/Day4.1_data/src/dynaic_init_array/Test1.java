package dynaic_init_array;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		//Dynamic initialization of array : class loading([I), then object created in heap, then array initialized
		int[]ints= {1,2,3,4,5}; // javac added implicitly new int[]
		System.out.println("ints array elements: ");
		for(int i: ints) {
			System.out.println(i);
		}
		int[]ints2=new int[] {10,20,30,40,50};
		
//		System.out.println("ints2 array elements: ");
//		for(int i: ints2) {
//			System.out.println(i);
//			}
		
		System.out.println("ints2 array contents: "+Arrays.toString(ints2));  // arrays class : static method tostring()-> string representation of array
		
	}

}
