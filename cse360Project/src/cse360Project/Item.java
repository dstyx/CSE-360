/*Dean Styx: Group 18
 * This class is designed to work as a framework for the ArrayList to be manipulated
 * in main.
 */


package cse360Project;

public class Item {
	
	int priority, month, day;
	String description;
	char state; //W = working, C = complete, M = missed
	
	public Item(String des, int mon, int day, int prior, char status) {
		description = des;
		priority = prior;
		month = mon;
		this.day = day;
		state = status;
	}

}
