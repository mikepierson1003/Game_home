package game;

public class World {
	
	public static Rooms buildWorld() {
		
		Rooms Entrance = new Rooms("Entrance");
		Rooms Decontamination = new Rooms("Decontamination");
		Rooms Radar = new Rooms("Radar");
		Rooms Control = new Rooms("Control");
		Rooms Lablower = new Rooms("Lower Lab");
		Rooms Labupper = new Rooms("Upper Lab");
		Rooms Caf = new Rooms("Cafeteria");
		Rooms Kitchen = new Rooms("Kitchen");
		Rooms Generator = new Rooms("Generator");
		Rooms Engine = new Rooms("Engine");
		Rooms Sleepinglower = new Rooms("Lower Sleeping Quarters");
		Rooms Sleepingupper = new Rooms("Upper Sleeping Quarters");
		Rooms Observatoryupper = new Rooms("Upper Level Observatory");
		Rooms Observatorylower = new Rooms("Lower Level Observatory");
		Rooms Ocean = new Rooms("Ocean");
		Rooms Captain = new Rooms("Captains Quarters");
		Rooms Armory = new Rooms("Armory");

		
		Entrance.addExit(Decontamination, 'd');
		Entrance.addExit(Ocean, 'u');
		
		Decontamination.addExit(Entrance, 'u');
		Decontamination.addExit(Radar, 'd');
		
		Radar.addExit(Decontamination, 'u');
		Radar.addExit(Control, 'd');
		
		Control.addExit(Radar, 'u');
		Control.addExit(Lablower, 'n');
		Control.addExit(Generator, 's');
		Item flashlight = new Item("flashlight", "It's a flashlight.");
		Control.setItem("flashlight", flashlight);
		
		Generator.addExit(Control, 'n');
		Generator.addExit(Engine, 's');
		Item crowbar = new Item("crowbar", "It's a crowbar."); // creates item
		Generator.setItem("crowbar", crowbar); // puts item in the room
		
		Engine.addExit(Generator, 'n');
				
		Lablower.addExit(Caf, 'n');
		Lablower.addExit(Control, 's');
		Lablower.addExit(Labupper, 'u');
		Combination combinationsafe = new Combination("combination", "It's a combination for a safe");
		Lablower.setItem("combinationsafe", combinationsafe); // adds combination safe code to lower lab room
		NPC puppy = new NPC("puppy", "It's a puppy.");
		Lablower.setNPC("puppy", puppy);
		NPC ai = new NPC("ai voice", "It's the voice of the ships ai");
		Lablower.setNPC("ai", ai);
		
		Labupper.addExit(Lablower, 'd');
		Labupper.addExit(Kitchen, 'n');
		Labupper.addExit(Armory, 'w');
		Item flask = new Item("flask", "It's a flask filled with an unknown liquid.");
		Labupper.setItem("flask", flask);// used for end game
		
		Armory.addExit(Labupper, 'e');
		Item gun = new Item("gun", "It's a gun.");
		Armory.setItem("gun", gun);
		Armory.setLock(true); // locks armory
		
		
		
		
		Caf.addExit(Lablower, 's');
		Caf.addExit(Kitchen, 'u');
		Caf.addExit(Sleepinglower, 'n');
		Item food = new Item("food", "Its some food.");
		Caf.setItem("food", food);
		
		Kitchen.addExit(Caf, 'd');
		Kitchen.addExit(Labupper, 's');
		Kitchen.addExit(Sleepingupper, 'n');
		Item knife = new Item("knife", "It's a knife");
		Kitchen.setItem("knife", knife);
		
		Sleepingupper.addExit(Kitchen, 's');
		Sleepingupper.addExit(Sleepinglower, 'd');
		Sleepingupper.addExit(Observatoryupper, 'n');
		
		Sleepinglower.addExit(Sleepingupper, 'u');
		Sleepinglower.addExit(Caf, 's');
		Sleepinglower.addExit(Observatorylower, 'n');
		Sleepinglower.addExit(Captain, 'e');
		Item pillow = new Item("pillow", "Why would you need a pollow?");
		Sleepinglower.setItem("pillow", pillow);
	
		Captain.addExit(Sleepinglower, 'w');
		Safe safe = new Safe("Safe", "It's a safe.");
		Captain.setItem("Safe", safe); //adds safe to captains room
		Item armorykey = new Item("armory key", "It's the key to the armory.");
		Captain.setItem("armorykey", armorykey); //Armory Key
		
		Observatoryupper.addExit(Sleepingupper, 's');
		Observatoryupper.addExit(Observatorylower, 'd');
		
		Observatorylower.addExit(Sleepinglower, 's');
		Observatorylower.addExit(Observatoryupper, 'u');
		
		return Entrance;
	}
}