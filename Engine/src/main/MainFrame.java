package main;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
	initialize();
	}
	
	public void initialize() {
		setTitle("p1.MainFrame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 800);
		
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
