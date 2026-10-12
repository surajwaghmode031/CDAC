package core.box;

import java.util.Scanner;

public class TestrBoxArray {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter no of boxes to make"); // i.e size of array 
		Box[]boxes = new Box[sc.nextInt()];
		
		for(int i=0;i<(boxes.length);i++){
			System.out.println("Enter box l W h");
			boxes[i]=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
			}
		
		System.out.println("Box dims and volume - for loop");
		for(int i=0;i<(boxes.length);i++) {
			System.out.println(boxes[i].getDimension());
			System.out.println(boxes[i].getVolume());
		}
		
		System.out.println("Box dims and volume - for each loop");
		for (Box b : boxes){
			System.out.println(b.getDimension());
			System.out.println("Volume "+b.getVolume());
		}
		sc.close();
	}

}
