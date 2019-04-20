package cse360Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Frame extends JFrame {
	
	private Details details;
	public Frame(String title) {
		super(title);
		
		//Layout manager
		setLayout(new BorderLayout());
		
		//Swing Componenents
		
		final JTextArea textArea = new JTextArea();
		JButton add = new JButton("Insert");
		
		details = new Details();
		// Adding componenets to pane
		Container c = getContentPane();
		
		c.add(textArea, BorderLayout.CENTER);
		//c.add(add,BorderLayout.SOUTH);
		c.add(details,BorderLayout.WEST);
		
		details.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				
			}
		});
		// Behavior
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("Hello\n");
				
			}
			
		});
	}
}
