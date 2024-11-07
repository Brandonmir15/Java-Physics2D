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

	public void applyImpulse(){
		// this.velocity = this.velocity(impulse(), 0);
	}


	public void useGravity() {

		this.acceleration = new Vector2D((float) (GRAVITY * (Math.pow(-1, ((float)((int)(Math.random() * 2)))))), GRAVITY);

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

	public void resolveCollision(PhysicsCircle B){

		Vector2D normal = position.subtract(B.position).normalize();

		// Calculate relative velocity
		Vector2D rv = velocity.subtract(B.velocity);

		// Calculate relative velocity in terms of the normal direction
		float velAlongNormal = rv.dot(normal);

		// Don't resolve if velocities are separating
		if(velAlongNormal > 0)
			return;

		// Calculate restitution [elasticity]
		// Assuming perfect elasticity [1.0]
		float e = 1; // float e = min(A.elasticity, B.elasticity);

		// Calculate impulse [j]
		float scalarImpulse = -(1 + e) * velAlongNormal;
		scalarImpulse /= 1 / mass + 1 / B.mass;

		// Inverse mass [invMass] is used a lot; put Object.invMass  = 1 / Obj.mass a property of the object...

		// Apply the impulse
			// This is so ugly ( T o T)
			// scalarImpulse * normal
		Vector2D impulse = normal.scale(scalarImpulse);

		//velocity -= 1/ A.mass * impulse
		//velocity = velocity.subtract(impulse);
		velocity = velocity.subtract(impulse.scale((1/mass)));

		//B.velocity += 1/ B.mass * impulse
		//B.velocity = B.velocity.add(impulse);
		B.velocity = velocity.add(impulse.scale((1/B.mass)));



		// For collisions involving differing masses
		/*
		float massSum = mass + B.mass;
		float ratio = mass / massSum;
		velocity -= ratio * impulse;

		ratio = B.mass / massSum;
		B.velocity += ratio * impulse;
		*/
	}

	public void update(float dt) {

		// Using Verlet Integration
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