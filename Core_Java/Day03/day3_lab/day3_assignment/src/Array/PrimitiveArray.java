package Array;

import java.util.Scanner;

public class PrimitiveArray {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter size of");
		double[]arr=new double[sc.nextInt()];
		System.out.println("Enter Elements:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextDouble();
		}
		System.out.println("Display Elements:");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		sc.close();
	}
}
