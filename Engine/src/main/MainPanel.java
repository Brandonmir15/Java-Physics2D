package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import PhysicsObjects.PhysicsCircle;
import PhysicsObjects.PhysicsSquare;
import vector.Vector2D;

public class MainPanel extends JPanel implements ActionListener {
	private PhysicsCircle c1;
	private PhysicsSquare s1;
	private Timer timer;


	private final Vector2D gravity = new Vector2D(0, 0.5f);
	private Vector2D velocity = new Vector2D(0, 0);

	public MainPanel() {
		initialize();
	}

	public void initialize() {
		setBackground(Color.gray);
		this.setPreferredSize(new Dimension(400, 400));


		Vector2D v1 = new Vector2D(0, 0);
		c1 = new PhysicsCircle(50, v1);
		s1 = new PhysicsSquare(50, v1, Color.green);

		// Set up the timer for animation
		timer = new Timer(16, this); // Roughly 60 FPS
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;


		g2d.setStroke(new BasicStroke(3));


		g2d.setColor(s1.color);
		g2d.draw(s1.shape);

		g2d.setColor(c1.color);
		g2d.draw(c1.shape);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// needs to be abstracted out

		velocity.y += gravity.y;

		s1.shape.x += velocity.x;
		s1.shape.y += velocity.y;

		c1.shape.x += velocity.x;
		c1.shape.y += velocity.y;

		if(s1.shape.y + (2 * s1.shape.height) >= 800){
			s1.shape.y = 800 - (2* s1.shape.height);
			velocity.y = -velocity.y * 0.9f;
		}



		//s1.useGravity(5);






		repaint();







	}
}
