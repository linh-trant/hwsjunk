//import java.awt.Point;

public class PointExercise {
	
	Point[] points = new Point[10];
	
	public PointExercise() { //Fill the points array with 10 random points with random x and y between 0 and 9.
		for (int i = 0 ; i < points.length; i++) {
			points[i] = new Point((Math.random()*10), (Math.random()*10));
			//points[i].setX(Math.random()*10);
			//points[i].setY((Math.random()*10));
			//points[i].set
		}
	}
	
	public Point[] equalDistanceTo(Point p) {
		Point[] result = new Point[2];
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i+1; j<points.length; j++) {
				if (points[i].euDis(p) == points[j].euDis(p)) {
					result[0] = points[i];
					result[1] = points[j];
					return result;
				}
			}
		}
		return null;
		
	}
	
	public void printArray() {
		for (int i=0; i< points.length; i++) {
			System.out.print(points[i].toString());
			System.out.print(" ");
		}
	}
	
	public void printPoint(int a) {
		System.out.println(points[a].toString());
	}
	
	public Point[] coorSum(double n) {
		Point[] result = new Point[2];
		for (int i = 0 ; i < points.length; i++) {
			for (int j = 0 ; j < points.length; j++) {
				if (points[i].getX()+points[i].getY()+points[j].getX()+points[j].getY() == n) {
					result[0] = points[i];
					result[1] = points[j];
					return result;
				}
			}
		}
		return null;
		
	}
	
	public void sortBy(String axis) {
		if (axis.equals("x")) {
			for (int i=0; i<points.length-1; i++) {
				for (int j=i+1; j<points.length; j++) {
					if (points[i].getX()>points[j].getX()) {
						Point mid = points[i];
						points[i] = new Point(points[j].getX(), points[j].getY());
						points[j] = new Point(mid.getX(), mid.getY());
					}
					else if (points[i].getX() == points[j].getX() && points[i].getY() > points[j].getY()) {
						Point mid = points[i];
						points[i] = new Point(points[j].getX(), points[j].getY());
						points[j] = new Point(mid.getX(), mid.getY());
					}
				}
			}
		}
		else {
			for (int i=0; i<points.length-1; i++) {
				for (int j=i+1; j<points.length; j++) {
					if (points[i].getY()>points[j].getY()) {
						Point mid = points[i];
						points[i] = new Point(points[j].getX(), points[j].getY());
						points[j] = new Point(mid.getX(), mid.getY());
					}
					else if (points[i].getY() == points[j].getY() && points[i].getX() > points[j].getX()) {
						Point mid = points[i];
						points[i] = new Point(points[j].getX(), points[j].getY());
						points[j] = new Point(mid.getX(), mid.getY());
					}
				}
			}
		}
	}
	
	public double[] distance(Point a) {
		double[] result = new double[10];
		for (int i=0; i<points.length; i++) {
			result[i] = points[i].euDis(a);
		}
		return result;
	}
	
	public void coorSum() {
		for (int i=0; i<points.length-1; i++) {
			for (int j = i+1; j<points.length; j++) {
				if (points[i].sumEqual(points[j])) {
					System.out.println(points[i].toString() + " " + points[j].toString());
				}
			}
		}
	}
	
	public void duplicate() {
		for (int i=0; i<points.length-1; i++) {
			for (int j = i+1; j<points.length; j++) {
				if (points[i].equals(points[j])) {
					System.out.println(points[i].toString() + " " + points[j].toString());
				}
			}
		}
	}
	
	public Point[] longestDistance() {
		Point[] answer = new Point[2];
		double longestDistance = 0;
		for (int i = 0; i<points.length-1; i++) {
			for (int j = i+1; j<points.length; j++) {
				if (points[i].euDis(points[j])>longestDistance) {
					answer[0] = points[i];
					answer[1] = points[j];
					longestDistance = points[i].euDis(points[j]);
				}
			}
		}
		return answer;
	}
	
	public double distanceSum() {
		double answer = 0;
		for (int i = 0; i<points.length-1; i++) {
			for (int j = i+1; j<points.length; j++) {
				answer = answer + points[i].euDis(points[j]);
			}
		}
		return answer;
	}
	
	public void equiTriangle(){
		for (int i = 0; i<points.length-2; i++) {
			for (int j = i+1; j<points.length-1; j++) {
				for (int k = j+1; k<points.length; k++) {
					if (points[i].euDis(points[j]) == points[i].euDis(points[k]) && points[i].euDis(points[j]) == points[j].euDis(points[k])) {
						System.out.println(points[i].toString() + " " + points[j].toString() + " " + points[k].toString() + " ");
					}
				}
				
			}
		}	
	}
}
