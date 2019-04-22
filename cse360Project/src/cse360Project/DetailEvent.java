package cse360Project;

import java.util.EventObject;

public class DetailEvent extends EventObject {
	
	private Item item;
	private char func;
	

	
	public DetailEvent(Object source, String name, int priority, int month, int day, char status, char func) {//OVERLOADING WITH priority month and day
		super(source);
		
		item = new Item(name, month, day, priority, status);
		this.func = func;
		
	}
	
	public DetailEvent(Object source, char func) {
		super(source);
		
		this.func = func;
	}
	
	public Item getItem() {
		return item;
	}
	
	public char getFunc() {
		return func;
	}

}
