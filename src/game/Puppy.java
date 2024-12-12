package game;

public class Puppy extends NPC {
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}

	int count = 0;
	@Override
	public void talk() {
		if (count == 0) {
			say("Hi! I'm an adorable puppy!");
			String[] options = { "Yes you are! Who's a good boy?", "Ew, no. You're actually kinda hideous." };
			count++;
			getResponse(options);
		} else if (count == 1) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options2 = { "Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies." };
			count++;
			getResponse(options2);
		} else {
			say("Hi puppy!");
		}
	}

	@Override
	public void response(int option) {
		if (count == 1) {
			switch (option) {
			case 1:
				say("I am! I'm a good boy!");
				break;
			case 2:
				say("I am adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");
				break;
			}
		} else if (count == 2) {
			switch (option) {
			case 1:
				say("Yay! Fetch!");
				Game.print("The puppy runs off and returns with a ball. The player receives the ball.");
				break;
			case 2:
				say("You're a bad person! I don't like you!");
				Game.print("The puppy runs away and doesn't come back.");
				Game.currentRoom.removeNPC("puppy");
				(new pause()).start();
				Game.print("(Player's thoughts): WAIT A SECOND!!!! Why was there a puppy here?????");
				break;
			}
		} else {
			switch (option) {
			case 1:
				say("Yip!");
				Game.print("The puppy wags his tail.");
				break;
			}
		}
	}
}