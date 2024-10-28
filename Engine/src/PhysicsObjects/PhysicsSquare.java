package PhysicsObjects;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

import vector.Vector2D;

public class PhysicsSquare extends PhysicsObject{
	
	public int n;
	public Vector2D cords;

	public Color color = Color.blue;
	public Rectangle2D.Double shape;
	private final int OFFSET = 400;
	
	public PhysicsSquare() {
		
		this.n = 1;
		this.cords = new Vector2D(0,0);
		new	Rectangle2D.Double(0,0, 1, 1);
		shape = new Rectangle2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, 1, 1);

	}
	
	public PhysicsSquare(int n, Vector2D cords) {
		
		this.n = n;
		this.cords = cords;
		this.shape = new Rectangle2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, n, n);

	}

	public PhysicsSquare(int n, Vector2D cords, Color color){
		this.n = n;
		this.cords = cords;
		this.shape = new Rectangle2D.Double(this.cords.x + OFFSET, this.cords.y + OFFSET, n, n);
		this.color = color;
	}



	
	
	
	
	

}
