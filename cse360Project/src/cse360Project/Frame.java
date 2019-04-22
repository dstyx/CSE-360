package cse360Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame {
	
	private Details details;
	private char sort = 'P';
	private Item holder;
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
		
		// Adding componenets to pane
		Container c = getContentPane();
		
		c.add(scroll, BorderLayout.CENTER);
		c.add(details,BorderLayout.WEST);
		
		
		//Detail Listener
		details.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				
				//Func.Add(list, event.getItem() );
				
				if(event.getFunc() == 'I') {//INSERT BUTTON LOGIC GOES HERE
					textArea.append("Added to List\n");
					String text = Func.itemToString(event.getItem());
					textArea.append(text);
					Func.Add(list, event.getItem());
					list = Func.sortList(list, sort);
				}
				
				
				else if(event.getFunc() == 'D') {//Delete BUTTON LOGIC GOES HERE
					
					boolean contains = list.contains(event.getItem());
					
					
					
					if(contains) {
						textArea.append("Deleting entry: \n");
						String text = Func.itemToString(event.getItem());
						textArea.append(text);
						list = Func.removeItem(list, event.getItem());
						list = Func.sortList(list, sort);
					}
					else {
						textArea.append(("The Item you entered does not exist on the list, please check for typos"));
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
					textArea.append("Reorganizing List\n" );
				}
				
				
				else if(event.getFunc() == 'U') {//CHANGE BUTTON LOGIC GOES HERE
					textArea.append("Changing\n");
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
				
				
				else if(event.getFunc() == 'S') {
					
				}
					
					
				else if(event.getFunc() == 'E') {//ERROR LOGIC GOES HERE
					textArea.append("ERROR, check user guide for valid inputs");
				}
				

				
			}
		});
		
		


	}
	

}
