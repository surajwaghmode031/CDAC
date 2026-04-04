package com.app.core;
import java.util.*;
public class Box{
private int length;
private int width;
private int height;

public Box(int l, int w, int h){
this.length=l;
this.width=w;
height=h;
}
//constuctor chaining
public Box(int side){
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