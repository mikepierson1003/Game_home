package game;

import java.io.Serializable;
import java.util.HashMap;

public class Rooms implements Serializable {
	
	private Rooms north;
	private Rooms south;
	private Rooms east;
	private Rooms west;
	private Rooms up;
	private Rooms down;
	private boolean lock;
	private String name;
	
	HashMap<String, Item> item = new HashMap<String, Item>();
	HashMap<String, NPC> npc = new HashMap<String, NPC>();
	
	//Rooms constructor
	public Rooms(String name) {
		this.name = name;
		Game.save.put(name, name); // check this
	}
	
	public String getDescription() {
		return Game.descriptions.get(name);
	}
	
	public Item getItem(String name) {
		return item.get(name);
	}
	
	public void setItem(String name, Item i) {
		item.put(name, i);
	}
	
	public void removeItem(String name) {
		item.remove(name);
	}
	
	public void setNPC(String name, NPC i) {
		npc.put(name,  i);
	}
	
	public NPC getNPC(String name) {
		return npc.get(name);
	}
	
	public String toString() {
		return Game.descriptions.get(name);
	}
	
	public boolean getLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Rooms getExit(char direction) {
		if (direction == 'n') {
			return north;
		} else if (direction == 's') {
			return south;
		} else if (direction == 'e') {
			return east;
		} else if (direction == 'w') {
			return west;
		} else if (direction == 'u') {
			return up;
		} else if (direction == 'd') {
			return down;
		} else {
			return null;
		}
			
	}
	
	public void addExit(Rooms Room, char direction) {
		if (direction == 'n') {
			north = Room;
		} else if (direction == 's') {
			south = Room;
		} else if (direction == 'e') {
			east = Room;
		} else if (direction == 'w') {
			west = Room;
		} else if (direction == 'u') {
			up = Room;
		} else if (direction == 'd') {
			down = Room;
		}
	}	
}