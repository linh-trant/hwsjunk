import java.util.ArrayList;

public class Course {
	
	private String courseNumber;
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	public void printNote() {
		System.out.println(courseNumber);
		for (int i=0; i<notes.size(); i++) {
			System.out.println(notes.get(i).toString());
		}
	}
	
	public String getCourse() {
		return courseNumber;
	}
	
	public void assignNote(Note n) {
		notes.add(n);
	}
	
	public void assignCourse(String a) {
		this.courseNumber = a; //ask teaching fellows for this
	}
	
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
}
