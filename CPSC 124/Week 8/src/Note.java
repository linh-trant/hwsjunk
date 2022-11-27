
public class Note {
	
	private String date;
	private String dailyNote;
	
	public String getDailyNote() {
		return dailyNote;
	}
	
	public void assignDate(String t) {
		date = t;
	}
	
	public void assignNote(String t) {
		dailyNote = t;
	}
	
	public String getDate() {
		return date;
	}
	
	public String toString() {
		return date + ": " + dailyNote;
	}
}
