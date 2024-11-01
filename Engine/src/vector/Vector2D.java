package vector;

public class Vector2D {
	
	public float x;
	public float y;
	
	public Vector2D() {
		this.y = 0;	
		this.x = 0;
	}
	public Vector2D(float x, float y) {
		this.y = y;	
		this.x = x;
	}

	//Getters-Setters
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
	return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public float findDotProduct(Vector2D vector) {
		float dotProd = (vector.x * this.x )+ (vector.y * this.y);
		return dotProd;
	}
	
	//Modules
	public Vector2D add(Vector2D other) {
		return new Vector2D(x + other.x, y + other.y);
	}
	public Vector2D subtract(Vector2D  other) {
		return new Vector2D(x - other.x, y - other.y);
	}
	public Vector2D scale(double scalar) {
		return new Vector2D(x * (float)scalar, y * (float)scalar);
	}
	//magnitude parameter vector intake was never used
	public float magnitude() {
		return (float) Math.sqrt((x * x)+(y * y));
	}

	public float distance(Vector2D other){

		return ((float)Math.sqrt((this.x - other.x) + (this.y - other.y)));
	}

	//square magnitude of vector
	/*
	public float lengthSquared(Vector2D v1){
		return Math.sqrt()
	}
	*/
	public Vector2D normalize() {
		return new Vector2D(x / magnitude(), y / magnitude());
	}
	
	public String toString() {
		return "X: " + this.x + "\tY: " + this.y;
	}

}
