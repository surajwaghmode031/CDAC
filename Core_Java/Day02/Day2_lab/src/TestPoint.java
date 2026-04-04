class Point2D{
private int x;
private int y;

public Point2D(int x,int y){
this.x=x;
this.y=y;
}

public String show(){
return "x= "+x+" "+"y= "+y;
}

public Boolean isEqual(Point2D p){
if(this.x==p.x &&this.y==p.y){
return true;
}
else
return false;
}

public double calculateDistance(Point2D point) {
int dx = point.x - this.x;
int dy = point.y - this.y;
return Math.sqrt(dx * dx + dy * dy);
}
}

public class TestPoint{

public static void main(String[]args){
Point2D	 p1 = new Point2D(4,7);
Point2D	 p2 = new Point2D(2,3);
Syatem.out.println("p1("+p1.show()+")");
Syatem.out.println("p2("+p2.show()+")");

if(p1.isEqual(p2)){
Syatem.out.println("Equals....!");
}
else{
Syatem.out.println("not Equals....!");
Syatem.out.println("Distance:"+p1.calculateDistance);
}
}

}