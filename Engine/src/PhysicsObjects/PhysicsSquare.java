package PhysicsObjects;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import vector.Vector2D;

public class PhysicsSquare extends PhysicsObject{
	
	int n;
	Vector2D cords;
	public Rectangle2D.Double shape;
	int offset = 400;
	
	public PhysicsSquare() {
		
		this.n = 1;
		this.cords = new Vector2D(0,0);
		new	Rectangle2D.Double(0,0, 1, 1);
		shape = new Rectangle2D.Double(this.cords.x, this.cords.y, 1, 1);

	}
	
	public PhysicsSquare(int n, Vector2D cords) {
		
		this.n = n;
		this.cords = cords;
		this.shape = new Rectangle2D.Double(this.cords.x + offset, this.cords.y + offset, n, n);

		
		
	}
	
	
	
	
	

}
