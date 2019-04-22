package cse360Project;

import java.util.ArrayList;

public class Func {
	
	public static ArrayList<Item> Add(ArrayList<Item> listIn, Item incoming) {//List in is old list to be updated, income is incoming item
		
		listIn.add(incoming);
		
		
		return listIn;
	}
	
	
	public static ArrayList<Item> removeItem(ArrayList<Item> listIn, Item incoming){
		
		
		
		return listIn;
	}
	
	public static ArrayList<Item> sortList(ArrayList<Item> listIn, char sorting){//SORT THE LIST BY CHAR TAHT IS CYCLED THROUGH, P = priority, A = alphabetically, D = by date
		
		
		
		
		
		
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
			words = "The To-Do List is empty, please add items\n";
		}
		else {
			for(int i = 0; i < listIn.size(); i++) {
				words += itemToString(listIn.get(i));
			}
			words += "\n";
		}
		
		return words;
		

	}

}
