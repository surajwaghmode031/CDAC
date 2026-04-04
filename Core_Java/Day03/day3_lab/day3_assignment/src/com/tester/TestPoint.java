package com.tester;
import com.developers.geometry.*;

public class TestPoint{

public static void main(String[]args){
Point2D	 p1 = new Point2D(4,7);
Point2D	 p2 = new Point2D(2,3);
System.out.println("p1("+p1.show()+")");
System.out.println("p2("+p2.show()+")");

if(p1.isEqual(p2)){
System.out.println("Equals....!");
}
else{
System.out.println("not Equals....!");
System.out.println("Distance:"+p1.calculateDistance(p2));
}
}

}