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
		// Terminate program when closing Jframe (Window)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);




	}








}
