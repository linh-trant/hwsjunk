import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CanvasModuleMainInterfaceClassThingie {
	//declare your course manager here
	//public static CourseManager manager = new CourseManager();
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		
		ModuleManagement manager = new ModuleManagement();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Select one: a) Add a module b)Add Assignment to a module c)View all modules");
			String choice = scan.nextLine();
			if (choice.equals("a")) {
				System.out.println("Module Title to Add: ");
				String title = scan.nextLine();
				Module a = new Module();
				a.assignModuleTitle(title);
				manager.assignModule(a);
				
				
			} else if (choice.equals("b")){
				System.out.println("Find a Existing Module Title: ");
				String title = scan.nextLine();   // Name for module for you to search
				Module c = manager.findModule(title);
				while (c == null) {
					System.out.println("Course doesn't exist. Try again");
					title = scan.nextLine();
					c = manager.findModule(title);					
				}
				
				System.out.println("Assignment Title to Add: ");
				String AssignTitle = scan.nextLine(); // name for assignment to add to this module 
				c.addAssignment(AssignTitle);
				
			} else if (choice.equals("c")) {
				
				manager.printModule();
				
				//print all modules here
				//System.out.println("Module: Week 9");
				//System.out.println("Assignment: Week 9 Lab");
				
			}
			
			
		}
		
	}
}


