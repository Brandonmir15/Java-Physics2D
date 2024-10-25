package PhysicsObjects;
import java.awt.geom.Ellipse2D;

import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	float radius;
	Vector2D cords;
	public Ellipse2D.Double shape;
	int offset = 400;
	
	public PhysicsCircle(){

		this.radius = 1;
		this.cords = new Vector2D(0,0);
		shape = new Ellipse2D.Double(this.cords.x, this.cords.y, 1, 1);

	}
	public PhysicsCircle(float radius, Vector2D cords) {
		
		this.radius = radius;
		this.cords = cords;
		this.shape = new Ellipse2D.Double(this.cords.x + offset, this.cords.y + offset, radius, radius);
		
	}
	
}
