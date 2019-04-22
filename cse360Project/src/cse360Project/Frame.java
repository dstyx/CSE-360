package cse360Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Frame extends JFrame {
	
	private Details details;
	public ArrayList<Item> list = new ArrayList<Item>();
	
	
	public Frame(String title) {
		super(title);
		
		//Layout manager
		setLayout(new BorderLayout());
		
		//Swing Componenents
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		details = new Details();
		
		// Adding componenets to pane
		Container c = getContentPane();
		
		c.add(textArea, BorderLayout.CENTER);
		c.add(details,BorderLayout.WEST);
		
		
		//Detail Listener
		details.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				
				//Func.Add(list, event.getItem() );
				
				if(event.getFunc() == 'I') {//INSERT BUTTON LOGIC GOES HERE
					textArea.append("Added to List\n");
					String text = Func.itemToString(event.getItem());
					textArea.append(text);
				}
				else if(event.getFunc() == 'D') {//Delete BUTTON LOGIC GOES HERE
					textArea.append("Deleting entry: \n");
					String text = Func.itemToString(event.getItem());
					textArea.append(text);
				}
				else if(event.getFunc() == 'R') {//REORDER BUTTON LOGIC GOES HERE
					textArea.append("Reorganizing List\n");
				}
				else if(event.getFunc() == 'U') {//CHANGE BUTTON LOGIC GOES HERE
					textArea.append("Changing\n");
				}
				else if(event.getFunc() == 'P') {//PRINT BUTTON LOGIC GOES HERE
					textArea.append("Printing\n");
				}
				

				
			}
		});
		
		


	}
	

}
