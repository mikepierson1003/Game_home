package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Rooms currentRoom;
	public static Scanner input = new Scanner(System.in);
	public static GameGUI GUI;

	public static void main(String[] args) {
		currentRoom = World.buildWorld();
		readDescription();
		GUI = new GameGUI();	
		print(currentRoom);
	}
	
	public static void print(Object obj) {
			GUI.area.append(obj.toString()+"\n");
	}
	
	public static void processCommand(String command) {
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
					Game.print("You can't go that way.");
				else if (nextRoom.getName().equals("Ocean")) {
					Game.print("You died.");
					(new nap()).start();
				}
				else if (nextRoom.getLock() == true)
					Game.print("Room is locked");
				else {
					currentRoom = nextRoom;
					print(currentRoom);
				}
				break;
			case "x":
				Game.print("Thanks for walking through my game!");
				(new nap()).start();
				break;
			case "i":
				Game.print("You are carrying:");
				for (Item it : inventory)
					Game.print(it);
				Game.print(" ");//prints a space between lines
				break;
			case "take":
				Item i = currentRoom.getItem(words[1]);
				if(i == null)
					Game.print("There is nothing to take.");
				else {
					currentRoom.setItem(null, null);
					inventory.add(i);
					Game.print("You picked up the "+i.getName(command)+".");
					currentRoom.removeItem(i.getName(command));
				}
				break;
			case "look":
				Item i1 = currentRoom.getItem(words[1]);
				//I need an Item variable to set equal to the Item found in the inventory
				//so I can check for it in the later part of the else if statement
				
				boolean i1_i = inventory.contains(words[1]);
				if(currentRoom.getItem(words[1]) == i1) {
					Game.print("You are looking at the "+words[1]+".");
					Game.print(i1.getDesc(words[1]));
				} else if(i1_i == true) {
					
					
					for(Item it : inventory)
						if(it == i1) { //Need Item Inventory Variable in this if statement
							Game.print("You are looking at the "+words[1]+".");
							Game.print(i1.getDesc(words[1]));
							break;
						}
					
				} else
					Game.print("There is nothing to look at.");
				break;
				
				
				
/*				
				Item i1 = currentRoom.getItem(words[1]);
				boolean i1_i = inventory.contains(words[1]);
				if(i1 null)
					Game.print("There is nothing to look at.");
				else if(currentRoom.getItem(words[1]) == i1) {
					Game.print("You are looking at the "+words[1]+".");
					Game.print(i1.getDesc(words[1]));
				} else if(i1_i == true) {
					Game.print("You are looking at the "+words[1]+".");
					Game.print(i1.getDesc(words[1]));
					
					
				for(Item it : inventory)
					if(it == i1) {
						Game.print("You are looking at the "+words[1]+".");
						Game.print(i1.getDesc(words[1]));
						break;
					}
*/				
				
				
			case "use":
				Item i2 = currentRoom.getItem(words[1]);
				if(i2 == null)
					Game.print("You cant use that here.");
				else {
					Game.print("You used the "+i2.getName(command)+".");
					i2.use(command);
				}	
				break;
			case "open":
				Item i3 = currentRoom.getItem(words[1]);
				if(i3 == null)
					Game.print("You cant open this.");
				else {
					Game.print("You opened the "+i3.getName(command)+".");
					i3.open(command);
				}
				break;
			case "talk":
				NPC npc = currentRoom.getNPC(words[1]);
				if(npc == null)
					Game.print("There is no one to talk to.");
				else
					Game.print("You are talking to the "+npc.getName()+".");
					npc.getResponse(words);
				break;
			case "save":
				saveGame(command);
				break;
			case "load":
				loadGame(command);
				break;
			default:
				Game.print("I don't know what that means.");
			}
	}
	
	

	
	
	public static HashMap<String, Rooms> save = new HashMap<String, Rooms>();
	
	public static void saveGame(String fileName) {
		File f = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(save);
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File "+fileName+" not found.");
		} catch (IOException ex) {
			System.out.println("save game IO exception");
		}
	}
	
	public static void loadGame(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Rooms) stream.readObject();
			inventory = (ArrayList) stream.readObject();
			save = (HashMap) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File "+fileName+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("load game IO exception");
		} catch (ClassNotFoundException ex) {
			System.out.println("load game Class not found exception");
		}
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
	
}