package PhysicsObjects;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
//import jdk.incubator.vector.VectorShape;
import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	public float radius;
	public Ellipse2D.Double shape;

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

		this.checkWindowCollision();

	}


	// Circle and boarder collision check and collision implementation
	public void checkWindowCollision(){

		// Floor
		if(this.shape.y + (2 * this.shape.height) >= 800){
			this.shape.y = 800 - (2 * this.shape.height);
			velocity.y = -velocity.y * 0.9f;
		}

		// Ceiling
		if(this.shape.y + (2 * this.shape.height) <= 0){
			// Correction for the window option panel
			this.shape.y = -200;
			this.velocity.y = -velocity.y * 0.9f;
		}

		// Right boundary
		if(this.shape.x + (2 * this.shape.height) >= 800){
			this.shape.x = 800 - (2 * this.shape.height);
			this.velocity.x = -velocity.x * 0.9f;
		}

		//Left boundary
		if(this.shape.x + (2 * this.shape.x) <= 0){
			this.shape.x = 0;
			this.velocity.x = -velocity.x * 0.9f;
		}

	}

	// Collision detection
	public void circleCircleIntersect(PhysicsCircle otherCircle){

		// Distance in terms of vector?

		if ((radius + otherCircle.radius) >= this.position.distance(otherCircle.position).magnitude()){

			this.setColor(Color.RED);
			otherCircle.setColor(Color.RED);

		this.testCollision(otherCircle);

		}
		else {
			this.setColor(Color.BLUE);
			otherCircle.setColor(Color.BLUE);
		}
	}



	public void testCollision(PhysicsCircle B){
		acceleration = acceleration.scale(-10);
		B.acceleration = acceleration.scale(-10);
	}


	// Relative velocity between two circles
	public Vector2D relativeVelocity(PhysicsCircle other) {

        return velocity.subtract(other.velocity); //velocity.findDotProduct(relativeVelocity);

	}

	public void elasticity (Vector2D relativeVelocity){
		//return e;
	}

}

