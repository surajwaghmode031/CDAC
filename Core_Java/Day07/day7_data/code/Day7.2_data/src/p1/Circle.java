package p1;

public class Circle extends BoundedShape {
	
	private double radius;
	
	

	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	

	@Override
	public String toString() {
		return "Circle "+ super.toString()+" radius=" + radius ;
	}



	@Override
	public double calcArea() {
		return PI*radius*radius;
	}

	@Override
	public double calcPerimeter() {
		return 2*PI*radius;
	}

}
