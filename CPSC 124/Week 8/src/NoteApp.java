import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NoteApp {
	//declare your course manager here
	//public static CourseManager manager = new CourseManager();
	 
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		
		CourseManager manager = new CourseManager();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("a) Select a course to add a note b)View Class");
			String choice = scan.nextLine();
			if (choice.equals("a")) {
				System.out.println("Course number: ");
				String courseNum = scan.nextLine();   // this is the number to the course
				System.out.println("Add a note");
				String note = scan.nextLine();  //this is the notes you put in
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				String d = dateFormat.format(date); // this is the current date string
				
				//Your code here
				Note n = new Note();
				n.assignNote(note);
				n.assignDate(d);
				
				Course c = manager.findCourse(courseNum);
				
				if (c==null) {
					c = new Course();
					c.assignCourse(courseNum);
					c.assignNote(n);
					manager.assignCourse(c);
				} else c.assignNote(n);
				
			} else if (choice.equals("b")) {
				System.out.println("Course number: ");
				String courseNum = scan.nextLine();// this is the number to the course
				
				Course c = manager.findCourse(courseNum);
				if (c == null) {
					System.out.println("Course doesn't exist.");
				}
				else {
					c.printNote();					
				}
				}
			}
			
			
		}
		
	}



