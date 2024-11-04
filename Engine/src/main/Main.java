package main;

import java.awt.Color;
import java.awt.Dimension;



public class Main{

	public static void main(String[] args) {

		MainFrame frame1 = new MainFrame();
		MainPanel panel1 = new MainPanel();
		
		//Cast border for window
		panel1.setPreferredSize(new Dimension(800, 800));
		panel1.setBackground(Color.black);
		frame1.add(panel1);
		
		frame1.setVisible(true);









	}

}
