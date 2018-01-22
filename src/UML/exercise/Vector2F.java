package UML.exercise;
/**
 * Working with 2D vectors are great when creating a game 2D game.
 * I bet there is a 2d vector library some where out there. 
 * But I not just create it our selves.  
 * @author Jonas Andrée
 *
 */
public class Vector2F {
	public float xPosition;
	public float yPosition; 
	
	public static float gameWorldXPosition;
	public static float gameWorldYPosition;
	
	/**
	 * Creates a new vector 0 with x and y parameters
	 */
	public Vector2F() {
		this.xPosition = 0.0f;
		this.yPosition = 0.0f;
	}
	/**
	 * Creates a new vector with x and y parameters
	 * @param xPosition
	 * @param yPosition
	 */
	public Vector2F(float xPosition, float yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	/**
	 * Returns a zero vector
	 * @return
	 */
	public static Vector2F zero() {
		return new Vector2F(0,0);
	}
	/**
	 * Normalizing a vector involves two steps: 
	 * 	1 calculate its length, then, 
	 *  2 divide each of its (xy or xyz) components by its length.
	 */
	public void normalize() {
		double length = Math.sqrt(xPosition*xPosition + yPosition*yPosition);
		if(length != 0.0) {
			float s = 1.0f / (float) length;
			xPosition *= s;
			yPosition *= s;
		}
	}
	/**
	 * Getter for vector 
	 * @return position of the vector on the screen.
	 */
	public Vector2F getScreenLocation() {
		return new Vector2F(xPosition,yPosition);
	}
	/**
	 * getter for vector 
	 * @return
	 */
	public Vector2F getWorldLocation() {
		return new Vector2F(xPosition - gameWorldXPosition,yPosition - gameWorldYPosition);
	}
	/**
	 * Checks if the vectors are the same.
	 * @param vector
	 * @return true if vector is the same
	 */
	public boolean equals(Vector2F vector) {
		return (this.xPosition == vector.xPosition && this.yPosition == vector.yPosition);
	}
	/**
	 * Creates a copy of a vector
	 * @param vector
	 * @return new 2d vector
	 */
	public Vector2F copy(Vector2F vector) {
		xPosition = vector.xPosition;
		yPosition = vector.yPosition;
		return new Vector2F(xPosition, yPosition);
	}
	/**
	 * Adds 
	 * @param vector
	 * @return
	 */
	public Vector2F add (Vector2F vector) {
		xPosition = xPosition + vector.xPosition;
		yPosition = yPosition + vector.yPosition;
		
		return new Vector2F(xPosition, yPosition);
	}
	/**
	 * Sets where the vector is placed in the game world
	 * @param gWX
	 * @param gWY
	 */
	public static void setGameWorldVariables(float gWX, float gWY) {
		gameWorldXPosition = gWX;
		gameWorldYPosition = gWY;
	}
	/**
	 * Gets the distance between two vectors.
	 * @param vector0
	 * @param vector1
	 * @return
	 */
	public static double getDistanceOnScreen(Vector2F vector0, Vector2F vector1) {
		float v0 = vector0.xPosition - vector1.xPosition;
		float v1 = vector0.yPosition - vector1.yPosition;
		return Math.sqrt(v0*v0+v1*v1);
	}
	/**
	 * Returns the distance between this vector and another vector
	 * @param vector
	 * @return
	 */
	public double getDistanceBetweenWorldVectors(Vector2F vector) {
		float dx = Math.abs(getWorldLocation().xPosition - vector.getWorldLocation().xPosition);
		float dy = Math.abs(getWorldLocation().yPosition - vector.getWorldLocation().yPosition);
		return Math.abs(dx*dx-dy*dy);
	}
}
