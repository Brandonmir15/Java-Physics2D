package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import java.util.List;

import PhysicsObjects.PhysicsCircle;
import PhysicsObjects.PhysicsSquare;
import vector.Vector2D;

import static PhysicsObjects.PhysicsCircle.broadPair;
import static PhysicsObjects.PhysicsCircle.keyValueResolve;


public class MainPanel extends JPanel implements Runnable {

	private Thread game;
	private boolean running = true;
	private PhysicsCircle circle;
	private Timer timer;
	private final Vector2D gravity = new Vector2D(0, 0.5f);
	//private Vector2D velocity = new Vector2D(0, 0);

	private static List<PhysicsCircle> circles = new ArrayList<>();

	public MainPanel() {
		initialize();
		startGame();
	}

	public void initialize() {
		setBackground(Color.gray);
		this.setPreferredSize(new Dimension(400, 400));

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

		//Color color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));

		//Create new circle at mouse position, random color, set radius
			//Add impulse to created PhysicsCircle
		PhysicsCircle newCircle = new PhysicsCircle(25, new Vector2D(x, y));
		circles.add(newCircle);
		repaint();
	}



	private void startGame() {
		game = new Thread(this);
		game.start();
	}


	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerUpdate = 1000000000.0 / 60.0; // 60 FPS
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerUpdate;
			lastTime = now;

			while (delta >= 1) {
				update();
				delta--;
			}

			repaint();

			try {
				Thread.sleep(2); // Slight pause to help CPU usage
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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

	public void update() {
		for (int i = 0; i < circles.size(); i++) {
			PhysicsCircle circle1 = circles.get(i);

			circle1.useGravity();
			circle1.updateShape();

			keyValueResolve(broadPair(circles));

			circle1.update(1 / 120);

		}
	}
}