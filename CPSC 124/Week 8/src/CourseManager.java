import java.util.ArrayList;

public class CourseManager {
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public void assignCourse(Course c) {
		if (findCourse(c.getCourse()) == null)
		courses.add(c);
	}
	
	public Course findCourse(String a) {
		for (int i=0; i<courses.size(); i++) {
			Course c = courses.get(i);
			if (c.getCourse().equals(a)) {
				return c;
			}
		}
		return null;
	}
}
