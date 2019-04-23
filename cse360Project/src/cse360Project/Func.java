

package cse360Project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Func {
	
	
	
	/*
	 * Adds an item to the end of the List
	 */
	public static ArrayList<Item> Add(ArrayList<Item> listIn, Item incoming) {//List in is old list to be updated, income is incoming item
		
		listIn = sortList(listIn, 'P');//sort list as a priority to then increase size if need be
		int j = incoming.priority;
		
		for(int i = 0; i < listIn.size(); i++) {
			if( j == listIn.get(i).priority) {
				listIn.get(i).priority++;
				j++;
			}
		}
		
		listIn.add(incoming);
		
		
		return listIn;
	}
	
	
	
	/*
	 * Removes Item in list if already been checked if item was in list
	 */
	public static ArrayList<Item> removeItem(ArrayList<Item> listIn, Item incoming){
		int i = listIn.indexOf(incoming);
		
		listIn.remove(i);
		
		return listIn;
	}
	
	
	/*
	 * Method to reorganize the list depending on what sorting is inputted
	 */
	public static ArrayList<Item> sortList(ArrayList<Item> listIn, char sorting){//SORT THE LIST BY CHAR TAHT IS CYCLED THROUGH, P = priority, A = alphabetically, D = by date
		ArrayList<Item> sorted = new ArrayList<Item>();
		
		if(sorting == 'P') {//sorting by priority
			Collections.sort(listIn, new PriorityComparator());
		}
		else if(sorting == 'A') {//sorting by alphabetically
			Collections.sort(listIn, new AlphabetComparator());
		}
		else if(sorting == 'D') {//sorting by date
			Collections.sort(listIn, new DateComparator());
		}
		else {//error testing
			System.out.println("ERROR: NO CHAR GIVEN");
		}
		
		
		
		return listIn;
	}
	
	
	/*
	 * A method to turn an Item into a readable string with all elements being visable upon calling
	 */
	
	public static String itemToString(Item item) {
		String words = item.description + "\nPriority: " + item.priority + "\nDue Date: " + item.month + "/" + item.day +
				"\nStatus: " + item.state + "\n";
		
		return words;
		
		
	}
	
	/*
	 * A method to turn an array list into a string for use, calls upon the itemToString method
	 */
	
	public static String listToString(ArrayList<Item> listIn) {
		String words = "";
		
		if(listIn.isEmpty()) {
			words = "The To-Do List is empty, please add items\n";
		}
		else {
			for(int i = 0; i < listIn.size(); i++) {
				words += itemToString(listIn.get(i));
			}
			words += "\n\n";
		}
		
		return words;
		

	}
	
	
	/*
	 * Function designed to save a list to a txt file for later use
	 *
	 */
	public static void saveToFile(ArrayList<Item> listIn) throws IOException {
		
	}
	
	
	
	

	//static class to compare fields of differnt objects
	
	/*
	 * This class is to allow the comparing of two different item's names
	 */
	static class AlphabetComparator implements Comparator<Item>{

		@Override
		public int compare(Item i1, Item i2) {
			// TODO Auto-generated method stub
			return i1.description.compareTo(i2.description);
		}
		
	}
	
	
	/*
	 * This class is to allow the comparing of two different item's priorities
	 */
	static class PriorityComparator implements Comparator<Item>{

		@Override
		public int compare(Item i1, Item i2) {
			// TODO Auto-generated method stub
			return i1.priority - i2.priority;
		}
		
	}
	
	
	/*
	 * This class is to allow the comparing of two different item's Date's
	 */
	static class DateComparator implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			
			
			return o1.date-o2.date;
		}
		
		
	}


}


