package game;

public class ArmoryKey extends Item {

	public ArmoryKey(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}
	
	public void use(){
		if(Game.currentRoom.getName().equals("Upper Lab")) {
			Game.save.get("Armory").setLock(false);
			Game.print("Armory Unlocked.");
		} else
			Game.print("Armory is still locked.");
	}		
}
