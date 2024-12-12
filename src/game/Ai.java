package game;

public class Ai extends NPC {
	public Ai() {
		super("Ai", "The ship appears to have its own ai. What did it do?");
	}

	int count = 0;
	@Override
	public void talk() {
		if (count == 0) {
			say("Unauthorized personell detected.");
			String[] options = { "Hello?! Whos there?", "WhAt WaS tHaT?!?!" };
			count++;
			getResponse(options);
		} else if (count == 1) {
			say("State your buisness.");
			String[] options2 = { "I dont have any",
					"I can't remeber. All I know is that I woke up in this strange place." };
			count++;
			getResponse(options2);
		} else {
			say("Error, power issue.");
		}
	}

	@Override
	public void response(int option) {
		if (count == 1) {
			switch (option) {
			case 1:
				say("I am this ships ai. what are YOU doing here?");
				break;
			case 2:
				say("I'm nothing scary, I can assure you.");
				Game.print("You hear the whir of old technology trying to boot up.");
				break;
			}
		} else if (count == 2) {
			switch (option) {
			case 1:
				say("Likely story.");
				break;
			case 2:
				say("How did you get here? We have been lost for years, sunken 20,000 meters below the surface.");
				say("Our people have long forgetten about us.");
				Game.print("(Player's thoughts): I'm in a sunken ship!?");
				break;
			}
		} else {
			switch (option) {
			case 1:
				say("Error.");
				Game.print("It appears the ai has lost power");
				break;
			}
		}
	}
}