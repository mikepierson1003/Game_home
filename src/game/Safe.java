package game;

public class Safe extends Item {
	
	public Safe(String name, String desc) {
		super(name, desc);
	}
	
}
/*
	@Override
	public void open(String n){
		if(inventory.contains(Safe)) {  //make so that it checks if the combinationsafe is in the players inventory
			Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
			Item Diamond = new Item("Diamond", "It's a Diamond.");
			Game.inventory.add(Diamond);
		} else {
			Game.print("The safe is locked and you don't have the combination.");
		}
	}
}
*/