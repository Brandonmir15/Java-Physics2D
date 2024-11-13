package PhysicsObjects;

import vector.Vector2D;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public Color color = Color.blue;


	// We need this because we cooked the code
	public abstract void updateShape();

	public void applyImpulse(){
		// this.velocity = this.velocity(impulse(), 0);
	}


	public void useGravity() {
		//
		this.acceleration = new Vector2D((float) (GRAVITY * (Math.pow(-1, ((float)((int)(Math.random() * 2)))))), GRAVITY);

	}



	public void resolveCollision(PhysicsCircle B){

		Vector2D normal = position.subtract(B.position).normalize();

		Vector2D rv = velocity.subtract(B.velocity);

		float velAlongNormal = rv.dot(normal);

		// Don't resolve if velocities are separating
		if(velAlongNormal > 0)
			return;

		float elasticity = 0.9f; // float e = min(A.elasticity, B.elasticity);

		float scalarImpulse = -(1 + elasticity) * velAlongNormal;
		scalarImpulse /= 1 / mass + 1 / B.mass;

		Vector2D impulse = normal.scale(scalarImpulse);

		//velocity -= 1/ A.mass * impulse
		//velocity = velocity.subtract(impulse);
		acceleration = velocity.subtract(impulse.scale((mass))).scale(-100);

		//B.velocity += 1/ B.mass * impulse
		//B.velocity = B.velocity.add(impulse);
		B.acceleration = B.velocity.add(impulse.scale((B.mass))).scale(-100);

		// For collisions involving differing masses
		/*
		float massSum = mass + B.mass;
		float ratio = mass / massSum;
		velocity -= ratio * impulse;

		ratio = B.mass / massSum;
		B.velocity += ratio * impulse;
		*/
	}


	//	Pairs the circles in list for localCollision
	//

	// 	Cull duplicate pairs
	//	Buggy code ToT
	public void cullDupes(Map<PhysicsCircle, PhysicsCircle> pairs){



	}



		public void update(float dt) {

		// Using Varlet Integration
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