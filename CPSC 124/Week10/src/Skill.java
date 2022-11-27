
public class Skill {
	
	private String skillName;
	private int skillATK;
	private String skillType;
	
	public Skill(String a, String b, int c) {
		skillName = a;
		skillType = b;
		skillATK = c;
	}
	
	public String getSkillName() {
		return skillName;
	}
	
	public int getSkillATK() {
		return skillATK;
	}
	
	public String getSkillType() {
		return skillType;
	}
}
