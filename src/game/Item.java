package game;

import java.io.Serializable;

public class Item implements Serializable {

		private String name; // Item's name
		private String desc; // Description of the item
		
		public Item(String n, String d) {
			name = n;
			desc = d;
		}
		
		public String getName() {
			return name;
		}
		
		public String getDesc() {
			return desc;
		}
		
		public void open(String n) {
			Game.print("You can't open that!");
		}
		
		public void use(String n) {
			Game.print("You can't use that!");
		}
		
		public String toString() {
			return name;
		}
		
		public void push(String n) {
			Game.print("You cant push the"+n+".");
		}
		
		public void pull(String n) {
			Game.print("You cant pull the"+n+".");
		}
}