/*Dean Styx: Group 18
 * This class is designed to work as a framework for the ArrayList to be manipulated
 * in main.
 */


package cse360Project;

public class Item {
	
	int priority, month, day, date;
	String description;
	char state; //W = working, C = complete, M = missed
	
	public Item(String des, int mon, int day, int prior, char status) {
		description = des;
		priority = prior;
		month = mon;
		this.day = day;
		date = (month*100) + this.day;
		state = status;
	}
	
	@Override
	public boolean equals(Object obj) {
		return(this.description.equals(((Item) obj).description) && this.priority == ((Item) obj).priority
				&& this.month == ((Item) obj).month && this.day == ((Item) obj).day && this.state == ((Item) obj).state); 
	}
	
	public int getPriority() {
		return priority;
	}

}
