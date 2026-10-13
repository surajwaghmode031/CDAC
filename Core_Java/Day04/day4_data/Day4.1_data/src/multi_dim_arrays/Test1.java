package multi_dim_arrays;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		double[][] data=new double[3][4];
		int value=100;
		
		// display using : fpr loop
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				System.out.println(data[i][j]);
				}
			}
		
		// array initialization
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data[i].length;j++) {
				data[i][j]=value++;
				}
			}
		
		// easire way to print a multi dim array
		System.out.println("easire way to print a multi dim array"+Arrays.deepToString(data));

	}

}
