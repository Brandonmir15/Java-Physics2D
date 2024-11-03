package PhysicsObjects;

import vector.Vector2D;

import java.awt.*;


public abstract class PhysicsObject extends Vector2D{
	


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


	// We need this becuase we cooked the code
	public abstract void updateShape();


	
	public void useGravity(){
		this.acceleration = new Vector2D(0,GRAVITY);
	}


	
	public void update(float dt){

		// Using Verlet Integeration 
	
		Vector2D newAcceleration = acceleration.scale((0.016));
		Vector2D displacement = position.subtract(lastPosition);

		lastPosition = new Vector2D(position.x, position.y);
		position = position.add(displacement).add(newAcceleration);


		this.updateShape(); // cooked

	}

	public void checkEdges(){

		if(this.position.y >= 800){


		}
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