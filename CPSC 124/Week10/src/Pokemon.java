import java.util.ArrayList;

public class Pokemon {
	
	private String pokemonName;
	private double pokemonHP;
	private int pokemonATK;
	private int pokemonDEF;
	private int pokemonSPD;
	private double pokemonOriginalHP;
	private String pokemonType;
	private Skill[] skillList = new Skill[4];
	//private ArrayList<Skill> name = new ArrayList();
	
	public Pokemon(String a, String b, int c, int d, int e, int f, Skill[] g) {
		this.pokemonName = a;
		this.pokemonType = b;
		this.pokemonHP = c;
		this.pokemonOriginalHP = c;
		this.pokemonATK = d;
		this.pokemonDEF = e;
		this.pokemonSPD = f;
		this.skillList = g;
	}
	
	public String getPokemonName() {
		return this.pokemonName;
	}
	
	public double getPokemonHP() {
		return this.pokemonHP;
	}
	
	public double getPokemonOriginalHP() {
		return this.pokemonOriginalHP;
	}
	
	public void assignPokemonHP(double a) {
		this.pokemonHP = a;
	}
	
	public int getPokemonATK() {
		return this.pokemonATK;
	}
	
	public int getPokemonDEF() {
		return this.pokemonDEF;
	}
	
	public int getPokemonSPD() {
		return this.pokemonSPD;
	}
	
	public String getPokemonType() {
		return this.pokemonType;
	}
	
	public double attack(int a, int b, int c, String d, String e, String f) {
		double stab;
		if (d.equals(e)) {
			stab = 1.5;
		} else stab = 1;
		
		//d: pokemon type, attacker
		//e: skill type, attacker
		//f: pokemon type, defencer
		//I don't want to use tons of if, please help me
		
		double type;
		if ((e.equals("Grass") && f.equals("Water")) || (e.equals("Water") && f.equals("Fire")) || (e.equals("Fire") && f.equals("Grass"))) {
			type = 2;
		} else type = 0.5;
		
		return ((42*a*b/((double)c))/50 + 2)*stab*type;
	}
	
	public boolean dead() {
		if (this.pokemonHP>0) return true;
		else return false;
	}
}
