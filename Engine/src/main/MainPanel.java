package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import PhysicsObjects.PhysicsCircle;
import PhysicsObjects.PhysicsSquare;
import vector.Vector2D;
import vector.Vector2D_Test;

public class MainPanel extends JPanel implements ActionListener {

	private PhysicsCircle circle;

	private Timer timer;
	private final Vector2D gravity = new Vector2D(0, 0.5f);
	//private Vector2D velocity = new Vector2D(0, 0);


	private List<PhysicsCircle> circles = new ArrayList<>();

	public MainPanel() {
		initialize();
		//jk
	}

	public void initialize() {
		setBackground(Color.gray);
		this.setPreferredSize(new Dimension(400, 400));

		Vector2D v1 = new Vector2D(0, 0);


		timer = new Timer(16, this); // Roughly 60 FPS
		timer.start();

		addMouseListener(new MouseAdapter() {
			@Override

			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					SpawnCircleAtPos(e.getX() - 400, e.getY() - 400);
				}
			}
		});
	}

	private void SpawnCircleAtPos(int x, int y) {
		System.out.println("Mouse Clicked || (" + x + ", " + y + ")");

		Color color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));

		PhysicsCircle newCircle = new PhysicsCircle(25, new Vector2D(x, y), color);
		circles.add(newCircle);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setStroke(new BasicStroke(3));

		for (PhysicsCircle circle : circles) {
			g2d.fill(circle.shape);
			g2d.setColor(circle.color);
			g2d.draw(circle.shape);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (PhysicsCircle circle : circles) {
			circle.useGravity(0.5f);
		}

		for(int i = 0; i<circles.size(); i++){
			for(int j = i+1; j<circles.size(); j++){
				collision(circles.get(i), circles.get(j));
			}
		}




		repaint();
	}

	public static void collision(PhysicsCircle c1, PhysicsCircle c2){

		//FindDistance
		//check if less than critical
		// if so handle collision

		if(c1.distance(c2) < (c1.radius + c2.radius)){

			Vector2D temp = new Vector2D(c1.velocity.x, c1.velocity.y);
			c1.velocity = new Vector2D(c2.velocity.x, c2.velocity.y);
			c2.velocity = temp;


		}







	}








}

/*

Collision Detection is the next part the



 */
