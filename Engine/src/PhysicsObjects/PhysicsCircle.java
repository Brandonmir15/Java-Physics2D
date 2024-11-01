package PhysicsObjects;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.Vector;

import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	public float radius;

	public Ellipse2D.Double shape;

	private final int OFFSET = 400;

	public Vector2D velocity = new Vector2D(0,0);

	public PhysicsCircle(){

		this.radius = 1;
		this.cords = new Vector2D(0,0);
		shape = new Ellipse2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, 1, 1);

	}
	public PhysicsCircle(float radius, Vector2D cords) {
		
		this.radius = radius;
		this.cords = cords;
		this.shape = new Ellipse2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, radius, radius);
		
	}

	public PhysicsCircle(float radius, Vector2D cords, Color color){

		this.radius = radius;
		this.cords = cords;
		this.shape = new Ellipse2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, radius, radius);
		this.color = color;

	}

	/*
	public float getRadius(PhysicsCircle circle){
		return this.radius;
	}
	*/

	public void setColor(Color color){
		this.color = color;
	}


	@Override
	public void useGravity(float force) {
		// Added x-axis force
			// Randomized to -1 and 1
		Vector2D gravity = new Vector2D(force * ((int)(Math.random() * 3) - 1), force);
		velocity.y += gravity.y;

		velocity.x += gravity.x;
		velocity.y += gravity.y;

		this.shape.x += velocity.x;
		this.shape.y += velocity.y;


		// an issue with velocity here
		// Velocity Works but isn't being applied back
		if (this.shape.y + (2 * this.shape.height) >= 800) {
			this.shape.y = 800 - (2 * this.shape.height);
			velocity.y = -velocity.y * 0.9f;
		}

		// Added right window boundary
			// Need to implement left window boundary
		if (this.shape.x + (2 * this.shape.height) >= 800) {
			this.shape.x = 800 - (2 * this.shape.height);
			velocity.x = -velocity.x * 0.9f;
		}

		if (this.shape.x <= 0) {
			this.shape.x = 0; // When shape leaves x boundary, set to x-boundary
			velocity.x = -velocity.x * 0.9f;
		}

		// If circleAndCircle(true) invert the magnitude of Vector2D (distance)
			// When circle collide
			// At point of intersection (collision) find the inverse magnitude of the vector radiSum


		// Cords dont change, issue to be fixed
		System.out.print("(" + this.shape.x + "," + this.shape.y + ")");
		System.out.println(" | Velocity:" + velocity.y);

	}
}

