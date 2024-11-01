package PhysicsObjects;

import vector.Vector2D;

import java.awt.*;
import java.util.Vector;

public abstract class PhysicsObject extends Vector2D{
	
	protected Vector2D cords;
	Vector2D velocity = new Vector2D(0,0);

	protected final int OFFSET = 400;

	public Color color;

	


	public void useGravity(float force){

	}

	//Collision detection implementation
		//Collisions -> object intersects
		//Detect distance [d] between circle centers
			//If d <= c1.radius + c2.radius
				//Collision detected

	public static boolean circleAndCircle(PhysicsCircle thisCircle, PhysicsCircle otherCircle){
		float radiSum = thisCircle.radius + otherCircle.radius;

		//Check if the distance is equal to or less than the sumOfRadi
		return (thisCircle.distance(otherCircle) * thisCircle.distance(otherCircle) <= (radiSum * radiSum));
	}
/*
	public static boolean circleAndXXYY(PhysicsCircle c1, )

	public static boolean circleAndSquare(PhysicsCircle circle, PhysicsSquare square){

	}
	/*
	public static boolean circleAndSquare(PhysicsCircle c1, PhysicsSquare s1){
	return ***Something <= ***Something
	}
	 */





	// This cold implement use Gravity possible abstraction needed

	

}
