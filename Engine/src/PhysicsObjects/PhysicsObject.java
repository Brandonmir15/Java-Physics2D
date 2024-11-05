package PhysicsObjects;

import vector.Vector2D;

import java.awt.*;
import java.util.function.ToDoubleBiFunction;

public abstract class PhysicsObject extends Vector2D {

	//Constants
	protected final int OFFSET = 400;
	final float GRAVITY = 9.81f;

	//Physics
	public Vector2D position = new Vector2D();
	public Vector2D lastPosition = new Vector2D();
	public Vector2D velocity = new Vector2D();
	public Vector2D acceleration;
	public float mass;

	// JFrame
	public Color color;


	// We need this because we cooked the code
	public abstract void updateShape();

	/*
	// Apply a random x-axis impulse to each circle
	public int impulse() {
		// Create random value of -1 : 1
        return (int) Math.pow(-1, (int)((Math.random() * 2)));
	}
	*/

	public void applyImpulse(){
		// this.velocity = this.velocity(impulse(), 0);
	}


	public void useGravity() {

		this.acceleration = new Vector2D(GRAVITY * ((int)(Math.random() * 3) - 1), GRAVITY);

	}

	// V^(AB) * dot * normal = -e (V^(B) - V(A)) * dot * normal
	// Resulting velocity [V'] with an applied force and direction
		// Relative velocity with an applied force, direction, and multiplied by elasticity (Energy loss)
	// The circle will collide and bounce in a given direction with a force [normal * dot]
	// At a certain velocity [V^(AB)] with a given impulse (-e)
		// e.min(A.elasticity, B.elasticity);
	// Coefficient of restitution - Elasticity || Bounciness
	// Only one decimal value will be used during impulse calculation for Epsilon [e]
	// Using the lowest restitution involved in collision should give intuitive results
	// Newtons Law of Restitution states that V' = e * V
	// [velocity after collision] == [velocity before] * [constant]

	public void resolveCollision(PhysicsObject B){

		// Calculate relative velocity
		Vector2D rv = new Vector2D((B.velocity.x - velocity.x), (B.velocity.y - velocity.y));

		// Calculate relative velocity in terms of the normal direction
		// 			Applying relative velocity onto the normal
		float velAlongNormal = findDotProduct(rv, (distance(B)).normalize());

		// 					IMPORTANT !!!!
		// Resolve if objects are moving toward each other
		if(velAlongNormal > 0)
			return;

		// Calculate restitution
		double e = 0.98; // float e = min(A.elasticity, B.elasticity);

		// Calculate impulse [j] scalar
			// Should be a float, casting to double because [e] is a double
		double j = -(1 + e) * velAlongNormal;
		j /= 1 / mass + 1 / B.mass;

		// Inverse mass [invMass] is used a lot; put Object.invMass  = 1 / Obj.mass a property of the object...

		// Apply the impulse
			// This is so ugly ( T o T)
		Vector2D impulse = (distance(B)).normalize().scale(j);

		// A.velocity -= 1/ A.mass * impulse
		// A.velocity = A.velocity.subtract(impulse);
		velocity = velocity.subtract(impulse.scale((1/mass)));

		// B.velocity += 1/ B.mass * impulse
		// B.velocity = B.velocity.add(impulse);
		B.velocity = B.velocity.add(impulse.scale((1/B.mass)));
	}

	public void update(float dt) {

		// Using Verlet Integeration 

		Vector2D newAcceleration = acceleration.scale((0.016));
		velocity = position.subtract(lastPosition);

		lastPosition = new Vector2D(position.x, position.y);

		this.updateShape();

		position = position.add(velocity).add(newAcceleration);

		//this.updateShape();

	}



}

/*
 *  TODO: We need to find out how gravity is working in relation to dt and FPS
 *
 * 	Right Now I Am just eyeballing the Value but this could become an Issue in the future
 * 
 * 
 * 
 * 
 * 
 * 
 */