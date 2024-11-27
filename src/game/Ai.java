package game;

public class Ai extends NPC{
	public Ai() {
		super("Ai", "The ship appears to have its own ai. What did it do?");
		}
	
	
	
	@Override
	public void talk() {
		say("Unauthorized personell detected.");
		String[] options = {
				"Hello?! Whos there?",
				"WhAt WaS tHaT?!?!"
		};
		getResponse(options);
	}
	
	@Override
	public void response(int option) {
		switch(option) {
			case 1:
				say("I am this ships ai. what are YOU doing here?");
				break;
			case 2:
				say("I'm nothing scary, I can assure you.");
				break;
		}
	}
}
