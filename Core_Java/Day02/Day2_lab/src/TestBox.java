import java.util.*;
class Box{
private int length;
private int width;
private int height;

Box(int l, int w, int h){
this.length=l;
this.width=w;
height=h;
}
//constuctor chaining
Box(int side){
this(side,side,side);
}
public String getDimension(){
return "Dimensions: length="+ length +" width="+ width +" height="+ height;
}

public String getVolume(){
return "volume="+ length*width*height;
}

public boolean checkEquality(Box otherBox){
    return this.length==otherBox.length && this.width==otherBox.width && this.height==otherBox.height ;
}

public Box createNewBox(int loffSet,int woffSet,int hoffSet){
    Box newBox = new Box (this.length+loffSet,this.width+woffSet,this.height+hoffSet);
    return newBox;
}
}

public class TestBox{
public static void main(String[]ar){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Dimensions:");
Box b1 = new Box(sc.nextInt(),sc.nextInt(),sc.nextInt());
System.out.println("getDimension:"+b1.getDimension());
System.out.println("getVolume:"+b1.getVolume());
System.out.println("Enter cube the Dimensions:");
Box b2 = new Box(sc.nextInt());
System.out.println("getDimension:"+b2.getDimension());
System.out.println("getVolume:"+b2.getVolume());
System.out.println("Check Equality:");
if(b1.checkEquality(b2))
System.out.println("Equal");
else
System.out.println("Not equal");
System.out.println("Enter offset values:");
Box b3 = b1.createNewBox(sc.nextInt(),sc.nextInt(),sc.nextInt());
System.out.println("getDimension:"+b3.getDimension());
System.out.println("getVolume:"+b3.getVolume());
}
}

