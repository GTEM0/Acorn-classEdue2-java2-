package prj0831;

public class Duck{

	String name;
	String character;
	String power;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public Duck(String name, String character, String power) {
		super();
		this.name = name;
		this.character = character;
		this.power = power;
	}
	
	public Duck() {
		
	}
	@Override
	public String toString() {
		return "Duck [name=" + name + ", character=" + character + ", power=" + power + "]";
	}
	
	
}
