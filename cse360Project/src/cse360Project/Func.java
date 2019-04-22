package cse360Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Func {
	
	public static ArrayList<Item> Add(ArrayList<Item> listIn, Item incoming) {//List in is old list to be updated, income is incoming item
		
		listIn.add(incoming);
		
		
		return listIn;
	}
	
	
	public static ArrayList<Item> removeItem(ArrayList<Item> listIn, Item incoming){
		int i = listIn.indexOf(incoming);
		
		listIn.remove(i);
		
		return listIn;
	}
	
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
	
	public static ArrayList<Item> updateItem(ArrayList<Item> listIn, Item incoming, Item held, boolean holding){
		
		return listIn;
	}
	
	
	
	
	public static String itemToString(Item item) {
		String words = item.description + "\nPriority: " + item.priority + "\nDue Date: " + item.month + "/" + item.day +
				"\nStatus: " + item.state + "\n";
		
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
			words += "\n\n";
		}
		
		return words;
		

	}
	

	//static class to compare fields of differnt objects
	static class AlphabetComparator implements Comparator<Item>{

		@Override
		public int compare(Item i1, Item i2) {
			// TODO Auto-generated method stub
			return i1.description.compareTo(i2.description);
		}
		
	}
	
	static class PriorityComparator implements Comparator<Item>{

		@Override
		public int compare(Item i1, Item i2) {
			// TODO Auto-generated method stub
			return i1.priority - i2.priority;
		}
		
	}
	
	static class DateComparator implements Comparator<Item>{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			
			
			return o2.date-o1.date;
		}
		
		
	}


}


