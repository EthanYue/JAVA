class Point {
	double x, y, z;
	
	Point(double _x, double _y, double _z) {
		x = _x;
		y = _y;
		z = _z;
	}
	
	public void setX(double _x) {
		x = _x;
	}
	
	public void setY(double _y) {
		y = _y;
	}
	
	public void setZ(double _z) {
		z = _z;
	}
	
	public double calc(Point p) {
		return x - p.x + y - p.y + z - p.z;
	}
}


public class TestPoint {
	public static void main(String[] args) {
		Point p2 = new Point(1, 2, 3);
		System.out.println("distance=" + p2.calc(new Point(0.0, 0.0, 0.0)));
	}
}