/*
 * Dean Styx
 * Group 18
 * CSE360
 * 
 * Main function for running the GUI and Program
 */


package cse360Project;
import java.util.*;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Frame("To-do list");
				frame.setSize(1200, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		

		// TODO Auto-generated method stub

	}
	


}


