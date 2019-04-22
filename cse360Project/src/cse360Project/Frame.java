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
				}
				else if(event.getFunc() == 'D') {//Delete BUTTON LOGIC GOES HERE
					textArea.append("Deleting entry: \n");
					String text = Func.itemToString(event.getItem());
					textArea.append(text);
				}
				else if(event.getFunc() == 'R') {//REORDER BUTTON LOGIC GOES HERE
					if(sort == 'P') {
						sort = 'A';
						textArea.append("Now sorting alphabetically");
					}
					else if(sort == 'A') {
						sort = 'D';
						textArea.append("Now sorting by due date");

					}
					else {
						sort = 'P';
						textArea.append("Now sorting by priority");
					}
					textArea.append("Reorganizing List\n" + sort);
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
					
				}
				else if(event.getFunc() == 'E') {//ERROR LOGIC GOES HERE
					textArea.append("ERROR, check user guide for inputs");
				}
				

				
			}
		});
		
		


	}
	

}
