
public class Point {
	private double x;
	private double y;
	
	public Point() {
		x=y=0;
	}
	
	public Point(double x, double y) {
		this.x = Math.round(x);
		this.y = Math.round(y);
	}
	
	public boolean equals(Point other) {
		if (this.x == other.x && this.y == other.y) return true;
		else return false;
	}
	
	//returns Euclidean distance to another point
	public double euDis(Point other) {
		return Math.sqrt((this.x - other.x)*(this.x-other.x)+(this.y-other.y)*(this.y-other.y));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public boolean sumEqual(Point other) {
		if (this.x + this.y == other.x + other.y) return true;
		else return false;
	}
	
	//public void swap(Point other) {
		//Point mid = this;
		//System.out.println(mid.x + " " + mid.y);
		//this.x = other.getX();
		//this.y = other.getY();
		//other.setX(mid.getX());
		//other.setY(mid.getY());
		//System.out.println()
	//}

}
