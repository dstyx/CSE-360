package cse360Project;

import java.util.ArrayList;

public class Func {
	
	public static ArrayList<Item> Add(ArrayList<Item> listIn, Item income) {//List in is old list to be updated, income is incoming item
		
		
		
		return listIn;
	}
	
	
	public static String itemToString(Item item) {
		String words = item.description + "\nPriority: " + item.priority + "\nDue Date: " + item.month + "/" + item.day +
				"\nStatus: " + item.state;
		
		return words;
		
		
	}
	
	public static String listToString(ArrayList<Item> listIn) {
		String words = "";
		
		if(listIn.isEmpty()) {
			words = "The To-Do List is empty, please add items";
		}
		else {
			for(int i = 0; i < listIn.size(); i++) {
				words += itemToString(listIn.get(i));
			}
		}
		
		return words;
		

	}

}
