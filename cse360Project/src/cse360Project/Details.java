package cse360Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class Details extends JPanel {
	
	private EventListenerList listenerList = new EventListenerList();
	
	
	public Details() {
		Dimension size = getPreferredSize();
		size.width = 600;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		//Labels
		JLabel nameLabel = new JLabel("Item Description: ");
		JLabel priorityLabel = new JLabel("Prioroity Level: ");
		JLabel dueLabel = new JLabel ("Day Due: ");
		JLabel monthLabel = new JLabel("Month Due: ");
		JLabel statLabel = new JLabel("Status: ");
		
		//Text Fields
		final JTextField desField = new JTextField(30);
		final JTextField prioField = new JTextField(6);
		final JTextField dayField = new JTextField(2);
		final JTextField monthField = new JTextField (4);
		final JTextField statField = new JTextField (2);
		
		//Buttons
		JButton addBtn = new JButton("Add/Insert");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(desField.getText().isEmpty() || monthField.getText().isEmpty() || dayField.getText().isEmpty()) {//if any of these empty do nothing
					
				}
				else if(prioField.getText().isEmpty()) {//if priority is empty then return everything else 
					String description = desField.getText();
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					int status = Integer.parseInt(statField.getText());
				}
				else {//if all filled in return everything 
					String description = desField.getText();
					int priority = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					int status = Integer.parseInt(statField.getText());
					
				}
			}

		});
		JButton delete = new JButton("Delete/Remove");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JButton reorder = new JButton("Reorder");
		JButton change = new JButton("Change/Update");
		JButton print = new JButton("Print Report");
		
		
		
		
		
		//Setting up the GUI layout, Left Side
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(priorityLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(dueLabel,gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(monthLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(statLabel, gc);
		
		//second Column
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(desField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(prioField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(dayField, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(monthField, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		add(statField, gc);
		
		//buttons
		
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(addBtn, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(delete, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		add(reorder, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		add(change, gc);
		
		gc.gridx = 1;
		gc.gridy = 9;
		add(print, gc);
		
	}
	
	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i = 0; i < listeners.length; i +=2) {
			if(listeners[i] == DetailListener.class) {
				//((DetailListener)listeners[i+1]).detailEventOccurred(event);
			}
		}
	}
	
	
	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}
	
	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);
	}
}
