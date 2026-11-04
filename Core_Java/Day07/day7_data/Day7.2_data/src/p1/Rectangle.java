package p1;

public class Rectangle extends BoundedShape {
	private double width,hight;
	
	

	public Rectangle(int x, int y, double width, double hight) {
		super(x, y);
		this.width = width;
		this.hight = hight;
	}
	
	

	@Override
	public String toString() {
		return "Rectangle " +super.toString()+" width=" + width + ", hight=" + hight ;
	}



	@Override
	public double calcArea() {
		return width*hight;
	}

	@Override
	public double calcPerimeter() {
		return 2*( width*hight);
	}

}
