class Point {
	private double x;
	private double y;
	
	Point(double _x, double _y) {
		x = _x;
		y = _y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double _x) {
		x = _x;
	}
	
	public void setY(double _y) {
		y = _y;
	}
}


class Circle {
	private Point o;;
	private double radius;
	
	Circle(Point p, double r) {
		o = p;
		radius = r;	
	}
	
	Circle(double r) {
		o = new Point(0, 0, 0);
		radius = r;
	}
	
	boolean contains(Point p) {
		double x = p.getX() - o.getX();
		double y = p.getY() - o.getY();
		if (x*x + y*y > radius*radius) return false;
		else return true;
	}
	
	public void setO(double _x, double _y) {
		o.setX(_x);
		o.setY(_y);
	}
	
	public Point getO() {
		return o;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public doublel area() {
		return 3.14 * radius * radius;
	}
}


public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 2), 2);
		Circle c2 = new Circle(5);
		c1.setO(5, 6);
		c2.setRadius(9);
		Point p1 = new Point(5.2, 6.3);
		c1.contains(p1);
	}
}










