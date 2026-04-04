package com.developers.geometry;

public class Point2D{
protected int x;
protected int y;

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