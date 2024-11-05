package PhysicsObjects;


import java.awt.geom.Rectangle2D;
import java.awt.Color;


import vector.Vector2D;

public class PhysicsSquare extends PhysicsObject{
	
	public int n;


	public Rectangle2D.Double shape;

	Vector2D velocity = new Vector2D(0,0);

	public PhysicsSquare() {
		
		this.n = 1;
		this.position = new Vector2D(0,0);
		new	Rectangle2D.Double(0,0, 1, 1);
		shape = new Rectangle2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, 1, 1);

	}
	
	public PhysicsSquare(int n, Vector2D position) {
		
		this.n = n;
		this.position = position;
		this.shape = new Rectangle2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, n, n);

	}

	public PhysicsSquare(int n, Vector2D position, Color color){
		this.n = n;
		this.position = position;
		this.shape = new Rectangle2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, n, n);
		this.color = color;
	}

	public void updateShape() {
		this.shape.setFrame(this.position.x + OFFSET, this.position.y + OFFSET, n, n);
	}

	public void checkEdgeCollision() {

	}

}
