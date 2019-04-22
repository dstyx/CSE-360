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
		final JTextField monthField = new JTextField (2);
		final JTextField statField = new JTextField (2);
		
		//Buttons
		JButton addBtn = new JButton("Add/Insert");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
				boolean failed = false;
				try {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
				}
				catch(NumberFormatException c){
					failed = true;
				}
				
				if(failed == true) {//check if number is a number
					fireDetailEvent(new DetailEvent(this, 'E'));
				}
				else {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
					
					if( 1 > day || 31 < day || 1 > month || 12 < month) {
						fireDetailEvent(new DetailEvent(this, 'E'));
					}
					else {
						fireDetailEvent(new DetailEvent(this, name, prio, month, day, status, 'I'));
					}
				}
				desField.setText("");
				prioField.setText("");
				dayField.setText("");
				monthField.setText("");
				statField.setText("");
				
				

			}

		});
		JButton delete = new JButton("Delete/Remove");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				boolean failed = false;
				try {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
				}
				catch(NumberFormatException c){
					failed = true;
				}
				
				if(failed == true) {//check if number is a number
					fireDetailEvent(new DetailEvent(this, 'E'));
				}
				else {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
					
					if( 1 > day || 31 < day || 1 > month || 12 < month) {
						fireDetailEvent(new DetailEvent(this, 'E'));
					}
					else {
						fireDetailEvent(new DetailEvent(this, name, prio, month, day, status, 'D'));
					}
				}
				desField.setText("");
				prioField.setText("");
				dayField.setText("");
				monthField.setText("");
				statField.setText("");
				
				
			}

		});
		JButton reorder = new JButton("Reorder");
		reorder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fireDetailEvent(new DetailEvent(this, 'R'));
			}
			
		});
		JButton update = new JButton("Change/Update");
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				
				boolean failed = false;
				try {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
				}
				catch(NumberFormatException c){
					failed = true;
				}
				
				if(failed == true) {//check if number is a number
					fireDetailEvent(new DetailEvent(this, 'E'));
				}
				else {
					String name = desField.getText();
					int prio = Integer.parseInt(prioField.getText());
					int day = Integer.parseInt(dayField.getText());
					int month = Integer.parseInt(monthField.getText());
					char status = statField.getText().charAt(0);
					status = Character.toUpperCase(status);
					
					if( 1 > day || 31 < day || 1 > month || 12 < month) {
						fireDetailEvent(new DetailEvent(this, 'E'));
					}
					else {
						fireDetailEvent(new DetailEvent(this, name, prio, month, day, status, 'U'));
					}
				}
				desField.setText("");
				prioField.setText("");
				dayField.setText("");
				monthField.setText("");
				statField.setText("");
				
				
			}
			
		});
		JButton print = new JButton("Show Current List");
		print.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fireDetailEvent(new DetailEvent(this,'P'));
			}
			
		});
		JButton save = new JButton("Save your work (keeps current ordering)");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fireDetailEvent(new DetailEvent(this,'S'));
			}
		});
		JButton restart = new JButton("Restart List");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fireDetailEvent(new DetailEvent(this,'T'));
			}
		});
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fireDetailEvent(new DetailEvent(this, 'H'));
			}
			
		});
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireDetailEvent(new DetailEvent(this, 'C'));
			}
		});
		
		
		
		
		
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
		add(update, gc);
		
		gc.gridx = 1;
		gc.gridy = 9;
		add(print, gc);
		
		gc.gridx = 1;
		gc.gridy = 10;
		add(help, gc);
		
		gc.gridy = 11;
		add(clear, gc);
		
		gc.gridy = 12;
		add(restart, gc);
		
	}
	
	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i = 0; i < listeners.length; i +=2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener)listeners[i+1]).detailEventOccured(event);
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
