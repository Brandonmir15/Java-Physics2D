package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import PhysicsObjects.PhysicsCircle;
import PhysicsObjects.PhysicsSquare;
import vector.Vector2D;

public class MainPanel extends JPanel implements ActionListener {


	private Timer timer;
	private final Vector2D gravity = new Vector2D(0, 0.5f);
	private Vector2D velocity = new Vector2D(0, 0);


	private List<PhysicsCircle> circles = new ArrayList<>();

	public MainPanel() {
		initialize();
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




		repaint();
	}

	public static void collision(){





	}








}

/*

Collision Detection is the next part the



 */
