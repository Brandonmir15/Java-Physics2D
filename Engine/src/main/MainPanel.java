package main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.management.timer.Timer;
import javax.swing.JPanel;

import PhysicsObjects.PhysicsCircle;
import PhysicsObjects.PhysicsSquare;
import vector.Vector2D;

public class MainPanel extends JPanel{

	public void initialize() {
		
		setBackground(Color.gray);
		this.setPreferredSize(new Dimension(200, 200));
		//Timer timer = new Timer();
		//timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		// Create vector
		Vector2D v1 = new Vector2D(0, 0);
		// Create circle
		PhysicsCircle c1 = new PhysicsCircle(50, v1);
		//Create rectangle
		PhysicsSquare s1 = new PhysicsSquare(50, v1);

		
		//Stroke size
		g2d.setStroke(new BasicStroke(3));
	
		
		
		g2d.draw(s1.shape);

		//g2d.draw(new Line2D.Float(0, 0, v1.x, v1.y));
		//g2d.draw(new Line2D.Float(400, 400, v1.x, v1.y));
		//g2d.drawLine(FRAMEBITS, ERROR, ALLBITS, ABORT);

	}
}