package PhysicsObjects;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.Vector;

import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	public float radius;
	
	public Vector2D cords;

	public Color color = Color.blue;
	public Ellipse2D.Double shape;


	private final int OFFSET = 400;
	
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

	public void setColor(Color color){
		this.color = color;
	}




	
}
