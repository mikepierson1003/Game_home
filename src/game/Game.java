package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		runGame();
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static HashMap<String, String> descriptions = new HashMap<String, String>();
	
	public static void readDescription() {
		try {
			Scanner input = new Scanner(new File("Room names and Descriptions"));
			while(input.hasNextLine()) {
				String names = input.nextLine();
				String description = input.nextLine();
				input.nextLine();
				descriptions.put(names, description);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Rooms currentRoom;
	public static Scanner input = new Scanner(System.in);
	
	@SuppressWarnings("null")  // npc.talk(); on line 115 wanted this. why?
	public static void runGame() {
		currentRoom = World.buildWorld();
		readDescription();

		String command; //player's command
		do {
			System.out.println(currentRoom);
			System.out.print("What will you do? ");
			command = input.nextLine();
			String[] words = command.split(" "); // splits players command into multiple strings
			
			switch(words[0]) {
			case "n":
			case "s":
			case "e":
			case "w":
			case "u":
			case "d":
				Rooms nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null)
					System.out.println("You can't go that way.");
//				else if (nextRoom == )  // how to see if the next room is the ocean room?
//					System.out.println("You died.");
//					System.exit(0);
				else if (nextRoom.getLock() == true)
					System.out.println("Room is locked");
				else
					currentRoom = nextRoom;
				break;
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			case "i":
				System.out.println("You are carrying:");
				for (Item it : inventory)
					System.out.println(it);
				System.out.println(); //prints a space for esthetics
				break;
			case "take":
				Item i = currentRoom.getItem(words[1]);
				if(i == null)
					System.out.println("There is nothing to take.");
				else {
					currentRoom.setItem(null, null);
					inventory.add(i);
					System.out.println("You picked up the "+i.getName(command)+".");
					currentRoom.removeItem(i.getName(command));
				}
				break;
			case "look":
				Item i1 = currentRoom.getItem(words[1]);
				if(i1 == null)
					System.out.println("There is nothing to look at.");
				else
					System.out.println("You are looking at the "+words[1]+".");
				break;
			case "use":
				Item i2 = currentRoom.getItem(words[1]);
				if(i2 == null)
					System.out.println("You cant use that here.");
				else
					System.out.println("You used the "+i2.getName(command)+".");
				break;
			case "open":
				Item i3 = currentRoom.getItem(words[1]);
				if(i3 == null)
					System.out.println("You cant open this.");
				else
					System.out.println("You opened the "+i3.getName(command)+".");
				break;
			case "talk":
				NPC npc = currentRoom.getNPC(words[1]);
				if(npc == null)
					System.out.println("There is no one to talk to.");
				else
					System.out.println("You are talking to the "+npc.getName()+".");
					npc.getResponse(words);
				break;
			default:
				System.out.println("I don't know what that means.");
			}
			
		} while(!command.equals("x"));
		
		input.close();
		//test 1
	}
	
}