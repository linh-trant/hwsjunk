import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Week11Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		PointExercise pe = new PointExercise();		
		Point p = new Point(2,3);
		
		//System.out.println(Arrays.toString(pe.equalDistanceTo(new Point(2,2))));
		System.out.print("Begin array: ");
		pe.printArray();
		System.out.println();
		
		System.out.println("Smallest by?" );
		String smallestByAxis = input.nextLine();
		pe.sortBy(smallestByAxis);
		System.out.print("Smallest by " + smallestByAxis + " is ");
		pe.printPoint(0);
		
		System.out.println("Sort by?");
		String sortByAxis = input.nextLine();
		
		pe.sortBy(sortByAxis);
		
		System.out.print("After sort: ");
		pe.printArray();
		System.out.println();
		
		double[] ways = pe.distance(p);
		int current = 0;
		for (int i=0; i<ways.length; i++) {
			if (ways[i]<ways[current]) current = i;
		}

		System.out.print("The nearest point to P is ");
		pe.printPoint(current);
		
		System.out.print("Radius? ");
		double r = input.nextDouble();
		System.out.println("Points in points array that falls within a circle with point p and radius r is: ");
		for (int i=0; i<ways.length; i++) {
			if (ways[i]<=r) pe.printPoint(i);
		}
		
		System.out.println("Two points in points array where the sum of each two coordinates are the same: ");
		pe.coorSum();
		
		System.out.println("Two points in points array where their coordinates are the same: ");
		pe.duplicate();
		
		System.out.println("Pair of points in points array with the longest Euclidean distance between them: ");
		Point[] ans = pe.longestDistance();
		System.out.println(ans[0].toString() + " " + ans[1].toString());
		
		System.out.println("Total distance of every pair of points in the array: " + pe.distanceSum());
		
		System.out.println("Three points that form a equilateral triangle: ");
		pe.equiTriangle();
	}

}
