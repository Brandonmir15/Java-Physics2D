package PhysicsObjects;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import jdk.incubator.vector.VectorShape;
import vector.Vector2D;

public class PhysicsCircle extends PhysicsObject {
	
	public float radius;
	public Ellipse2D.Double shape;

	public PhysicsCircle(float radius, Vector2D position){

		this.radius = radius;
		this.position = position;
		this.lastPosition = new Vector2D(position.x, position.y);
		this.shape = new Ellipse2D.Double(this.position.x + OFFSET, this.position.y + OFFSET, radius, radius);

	}

	// Create constructor that takes in color for later


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
			velocity.y *= -1.0f;
		}

		// Ceiling
		if(this.shape.y + (2 * this.shape.height) <= 0){
			// Correction for the window option panel
			this.shape.y = -200;
			this.velocity.y *= -1.0f;
		}

		// Right boundary
		if(this.shape.x + (2 * this.shape.height) >= 800){
			this.shape.x = 800 - (2 * this.shape.height);
			this.velocity.x *= -1.0f;
		}

		//Left boundary
		if(this.shape.x + (2 * this.shape.x) <= 0){
			this.shape.x = 0;
			this.velocity.x *= -1.0f;
		}

	}

	// Collision detection
	public void circleCircleIntersect(PhysicsCircle otherCircle){

		// Distance in terms of vector?

		if ((radius + otherCircle.radius) >= this.position.distance(otherCircle.position).magnitude()){

			this.setColor(Color.RED);
			otherCircle.setColor(Color.RED);

		this.resolveCollision(otherCircle);

		}
		else {
			this.setColor(Color.BLUE);
			otherCircle.setColor(Color.BLUE);
		}
	}

	public static Map<PhysicsCircle, PhysicsCircle> broadPair(List<PhysicsCircle> circles) {

		Map<PhysicsCircle, PhysicsCircle> keyPairs = new HashMap<PhysicsCircle, PhysicsCircle>();

		for	(int i = 0; i < circles.size(); i++){
			for (int j = i + 1; j < circles.size(); j++){
				PhysicsCircle refCircle = circles.get(i);
				PhysicsCircle oppCircle = circles.get(j);

				if(i == j) continue;

				// This will pair all circles that are intersecting with each other
				if((refCircle.radius + oppCircle.radius) >= refCircle.position.distance(oppCircle.position).magnitude()){
					keyPairs.put(refCircle, oppCircle);
				}
			}
		}
		return keyPairs;
	}

	public static void keyValueResolve(Map<PhysicsCircle, PhysicsCircle> circles){
		for (Map.Entry<PhysicsCircle, PhysicsCircle> entry: circles.entrySet()) {

			PhysicsCircle key = entry.getKey();
			PhysicsCircle value = entry.getValue();

			key.intersectTest(value);
		}
	}

	public void intersectTest(PhysicsCircle otherCircle){

		if ((radius + otherCircle.radius) >= this.position.distance(otherCircle.position).magnitude() -2) {

			this.resolveCollision(otherCircle);

		}
	}

	public void testCollision(PhysicsCircle B){
		// When in checking constantly
		// Acceleration is applied un-intuitively

		System.out.println("Intersect");

		acceleration = velocity.scale(-100);
		B.acceleration = B.velocity.scale(-100);

		System.out.println("THIS" + this.velocity);
		System.out.println("THAT" + B.velocity);

		this.setColor(Color.BLUE);
		B.setColor(Color.BLUE);

	}

}

