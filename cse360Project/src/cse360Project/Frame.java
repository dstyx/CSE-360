

package cse360Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame {
	
	private Details details;
	private char sort = 'P';
	private Item holder;
	private int count = 0;
	private Boolean holding = false;
	public ArrayList<Item> list = new ArrayList<Item>();
	
	
	
	public Frame(String title) {
		super(title);
		
		//Layout manager
		setLayout(new BorderLayout());
		
		//Swing Componenents
		
		final JTextArea textArea = new JTextArea();
		final JScrollPane scroll = new JScrollPane(textArea);
		textArea.setEditable(false);
		details = new Details();
		
		// Adding components to pane
		Container c = getContentPane();
		
		c.add(scroll, BorderLayout.CENTER);
		c.add(details,BorderLayout.WEST);
		
		
		//Detail Listener
		details.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				
				
				if(event.getFunc() == 'I') {//INSERT BUTTON LOGIC GOES HERE
					
					boolean h = false;
					
					for(int i = 0; i < list.size(); i++) {
						if(event.getItem().description.compareTo(list.get(i).description) == 0 )
							h = true;
					}
					
					if(h) {
						textArea.append("Item is already on the list, please enter only unique descriptions\n");
					}
					else {
						textArea.append("Added to List\n\n");
						String text = Func.itemToString(event.getItem());
						textArea.append(text);
						list = Func.Add(list, event.getItem());
						list = Func.sortList(list, sort);
						textArea.append("\n");
					}

				}
				
				
				else if(event.getFunc() == 'D') {//Delete BUTTON LOGIC GOES HERE
					
					boolean contains = list.contains(event.getItem());
					
					
					
					if(contains) {
						textArea.append("Deleting entry: \n");
						String text = Func.itemToString(event.getItem());
						textArea.append(text);
						list = Func.removeItem(list, event.getItem());
						list = Func.sortList(list, sort);//sort remaining list by whatever is the active sorting
					}
					else {
						textArea.append(("The Item you entered does not exist on the list, please check for typos\n"));
					}

				}
				
				
				else if(event.getFunc() == 'R') {//REORDER BUTTON LOGIC GOES HERE
					if(sort == 'P') {
						sort = 'A';
						textArea.append("Now sorting alphabetically\n");
					}
					else if(sort == 'A') {
						sort = 'D';
						textArea.append("Now sorting by due date\n");

					}
					else {
						sort = 'P';
						textArea.append("Now sorting by priority\n");
					}
					list = Func.sortList(list, sort);
					textArea.append("Reorganizing List\n" );
				}
				
				
				else if(event.getFunc() == 'U') {//CHANGE BUTTON LOGIC GOES HERE
					if(holding == false) {
						holder = event.getItem();
						textArea.append("Now holding : \n" + Func.itemToString(holder) +
								"Please enter what item you wish to update/change, then press Change/Update again\n");
						holding = true;
					}
					else if(!list.contains(event.getItem())) {//IF HOLDING ALREADY BUT NEW ISN'T FOUND IN LIST
						textArea.append("Please enter an item that is on the list/check for typos in the boxes\n");
					}
					else if(list.contains(event.getItem())) {//IF HOLDING ALREADY AND FOUND CORRECT ITEM TO REPLACE 
						Func.removeItem(list, event.getItem());
						Func.Add(list, holder);

						
						textArea.append("Item: \n" + Func.itemToString(event.getItem()) + "Has Been replaced by: \n"
								+ Func.itemToString(holder));
						
						holding = false;
					}
				}

				
				
				else if(event.getFunc() == 'P') {//PRINT BUTTON LOGIC GOES HERE
					String text = Func.listToString(list);
					textArea.append("Printing\n");
					textArea.append(text);
				}
				
				
				else if(event.getFunc() == 'C') {//CLEAR BUTTON LOGIC
					textArea.selectAll();
					textArea.replaceSelection("");
					
				}
				
				
				else if(event.getFunc() == 'H') {//HELP LOGIC HERE
					textArea.append("TEXTFIELD HELP:\n"
							+ "Item Description: Enter any number of words to describe your task\n"
							+ "Priority Level: Enter any whole number to represent urgency (1 being the most urgent)\n"
							+ "Day Due: Enter the day it is due (1-31 all valid entries)\n"
							+ "Month Due: Enter the month the item is due (1-12 all valid entries\n"
							+ "Status: The current status of the object in list (W for working, N for Not Started, and C for completed\n"
							+ "BUTTON HELP:\n"
							+ "Add/Insert: Adds an Item with the parameters given. (All fields must be filled in)\n"
							+ "Delete/Remove: Removes an Item with the parameters given (All fields must match an item already in the list\n"
							+ "Reorder: Cycles through the different Ordering of the list (Default is priority)\n"
							+ "\tcycles through priority, alphabetically, and by due date, in that order\n"
							+ "Change/Update: First type in all fields of what you want the updated Item to be, press Change/Update\n"
							+ "\t then type in all fields which item that you wish to update, the press Change/Update again.\n"
							+ "\t Pressing clear button will clear the stored Item\n"
							+ "Show Current List: Show the list in the order that is currently selected\n"
							+ "Save: Saves the list onto a text document to print out\n"
							+ "Clear: Clears the text box as well clear the stored item in change/update\n"
							+ "Restart list: Cleans out the current list, this is permenant\n\n");

				}
				
				else if(event.getFunc() == 'T') {
					textArea.append("LIST CLEARED\n");
					list.clear();
				}
					
					
				else if(event.getFunc() == 'E') {//ERROR LOGIC GOES HERE
					textArea.append("ERROR, Please click HELP for valid inputs methods\n\n");
					if(holding)
						holding = false;


					
				}
				

				
			}
		});
		
		


	}
	

}
