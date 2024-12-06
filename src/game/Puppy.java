package game;

public class Puppy extends NPC {
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	@Override
	public void talk() {
		say("Hi! I'm an adorable puppy!");
		String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
		};
		getResponse(options);
	}
	@Override
	public void response(int option) {
		switch(option) {
		case 1:
			say("I am! I'm a good boy!");
			break;
		case 2:
			say("I am adorable! Why are you so mean?");
			Game.print("The puppy bites you. You deserve it.");
			break;
		}
	}
}


/**
public class Puppy extends NPC {
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
		}
	
		@Override
		public void talk() {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
			
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options2 = {
					"Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options2);
			
			say("Hi puppy!");
			String[] options3 = {
					
			};
			getResponse(options3);
		}
		
		@Override
		public void response(int option) {
		switch(option) {
			case 1:
				say("I am! I'm a good boy!");
				break;
			case 2:
				say("I am adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");
				break;
		}
		switch(option) {
			case 1:
				say("Yay! Fetch!");
				Game.print("The puppy runs off and returns with a ball. The player receives the ball.");
				break;
			case 2:
				say("You're a bad person! I don't like you!");
				Game.print("The puppy runs away and doesn't come back.");
				break;
		}
		switch(option) {
			case 1:
				say("Yip!");
				Game.print("The pyppy wags his tail.");
				break;
		}
	}
}
**/