package main;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) { // Check if MOUSE1 (left button) is pressed
					addLabelAtPosition(e.getX(), e.getY());
				}
			}
		});


	}

	private void addLabelAtPosition(int x, int y) {

		System.out.println("(" + x + "," + y + ")");
		revalidate();
		repaint();
	}






}
