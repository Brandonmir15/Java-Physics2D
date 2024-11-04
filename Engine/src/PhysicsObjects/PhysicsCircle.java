package PhysicsObjects;
import java.awt.geom.Ellipse2D;
import java.awt.Color;


import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	public float radius;
	public Ellipse2D.Double shape;
	

	public PhysicsCircle(){

		this.radius = 1;
		this.position = new Vector2D(0,0);
		this.lastPosition = new Vector2D(position.x, position.y);
		shape = new Ellipse2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, 1, 1);
		

	}
	public PhysicsCircle(float radius, Vector2D position) {
		
		this.radius = radius;
		this.position = position;
		this.lastPosition = new Vector2D(position.x, position.y);
		this.shape = new Ellipse2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, radius, radius);
		
	}

	public PhysicsCircle(float radius, Vector2D position, Color color){

		this.radius = radius;
		this.position = position;
		this.lastPosition = new Vector2D(position.x, position.y);
		this.shape = new Ellipse2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, radius, radius);
		this.color = color;

	}

	
	public void setColor(Color color){
		this.color = color;
	}


	public void updateShape() {
		this.shape.setFrame(this.position.x + OFFSET, this.position.y + OFFSET, radius, radius);
	}



}

