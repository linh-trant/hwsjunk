import java.util.ArrayList;

public class ModuleManagement {

	private ArrayList<Module> modules = new ArrayList<Module>();
	
	public void assignModule(Module a) {
		if (findModule(a.titleModule()) == null) {
			modules.add(a);
		}
	}
	
	public Module findModule(String a) {
		for (int i=0; i<modules.size(); i++) {
			Module b = modules.get(i);
			if (b.titleModule().equals(a)) {
				return b;
			}
		}
		return null;
	}
	
	public void printModule() {
		for (int i=0; i<modules.size(); i++) {
			System.out.println();
			modules.get(i).printModule();
			System.out.println();
		}
	}
}
