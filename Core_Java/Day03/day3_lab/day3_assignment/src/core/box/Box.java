package core.box;

public class Box {
	protected double length;
	protected double width;
	protected double height;
	
	public Box(double length, double width, double height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}
public String getDimension() {
	return "length="+length+" width="+width+" height="+height;
	}
public double getVolume() {
	return length*width*height;
}
}
