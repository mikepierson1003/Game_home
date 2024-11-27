package game;

public class Combination extends Item {
	
	public Combination(String name, String desc) {
		super(name, desc);
	}
		
	@Override
	public void use(String n) {
		Game.print("If you find a safe, try opening it!");
	}
}