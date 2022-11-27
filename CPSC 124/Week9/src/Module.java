import java.util.ArrayList;

public class Module {
	
	private ArrayList<String> lists = new ArrayList<String>();
	private String moduleTitle;
	
	public void assignModuleTitle(String a) {
		moduleTitle = a;
	}
	
	public String titleModule() {
		return moduleTitle;
	}
	
	public void addAssignment(String b) {
		lists.add(b);
	}
	
	public void printModule() {
		System.out.println(moduleTitle);
		for (int i=0; i<lists.size(); i++) {
			System.out.println("	" + lists.get(i));
		}
	}
	
}
