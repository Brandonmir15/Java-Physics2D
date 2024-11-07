package vector;

public class Vector2D_Test {

	//Add Subtract Scale Magnitude
	
	public static void main(String[] args) {
		Vector2D v1 = new Vector2D();
		Vector2D v2 = new Vector2D(1, 1);
		Vector2D v3 = new Vector2D(2, 2);
		
		System.out.println(v1.toString());
		
		System.out.println(v2.add(v3));
		
		System.out.println(v2.subtract(v3));
		
		System.out.println(v2.scale(5));
		
		//System.out.println(v2.magnitude(v3));
			//Previous magnitude()
	
		System.out.println(v2.normalize());
		
		System.out.println(v3.dot(v2));

	}
}
