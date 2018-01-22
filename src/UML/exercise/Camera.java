package UML.exercise;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Camera {
	public static Vector2F cameraPosition = new Vector2F();
	public static Vector2F map = new Vector2F();
	
	public static Rectangle render;
	
	private int width = 30;
	private int height = 30;
	// Rendering
	private int renderDistanceH = 35;
	private int renderDistanceW = 62;
	
	private void centerCamera() {
		cameraPosition.xPosition = MainGameLoop.width/2;
		cameraPosition.yPosition = MainGameLoop.height/2;
	}
	
	public void init() {
		System.out.println("Initializes Camera");
		centerCamera();

		render = new Rectangle((int)(Camera.map.xPosition + cameraPosition.xPosition - renderDistanceW*32/2), 
							   (int)(Camera.map.yPosition + cameraPosition.yPosition - renderDistanceH*32/2), 
							   renderDistanceW*32 + width, 
							   renderDistanceH*32 + height);
		
		Vector2F.setGameWorldVariables(map.xPosition, map.yPosition);
	}
	
	public static void update(float x, float y) {
		cameraPosition.xPosition = x;
		cameraPosition.yPosition = y;
	}

	public void tick(double deltaTime) {	
		render = new Rectangle((int)(Camera.map.xPosition + cameraPosition.xPosition - renderDistanceW*32/2), 
							   (int)(Camera.map.yPosition + cameraPosition.yPosition - renderDistanceH*32/2), 
							   renderDistanceW*32 + width, 
							   renderDistanceH*32 + height);	
	}
	public void render(Graphics2D g) {
		Vector2F.setGameWorldVariables(map.xPosition, map.yPosition);
	}
}
