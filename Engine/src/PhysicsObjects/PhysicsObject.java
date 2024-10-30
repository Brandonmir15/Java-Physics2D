package PhysicsObjects;

import vector.Vector2D;

import java.util.Vector;

public abstract class PhysicsObject {
	
	Vector2D coords;
	Vector2D velocity = new Vector2D(0,0);
	// I still think this is gonna be a problem
	
	


	public abstract void useGravity(float force);
	//

	
	// This cold implement use Gravity possible abstraction needed

	

}
