package lesson.eventlistener.mainloop.part3.fps.player.movment;

import java.awt.Color;
import java.awt.Graphics;

public class FramesPerSec {
	private static long lastTime;
	private static long currentTime;
	private static double currFPS  = 120D;
	// Will speed up the game if the game runs slow
	private static double deltaTime; 
	private static double numberOfSecundsPerTick;
	
	private static int frames; 
	
	private static int ticks;
	
	public static void init() {
		// returns the most exact time in nanoseconds
		lastTime = System.nanoTime();
		System.out.println(lastTime);
		deltaTime = 0;
		numberOfSecundsPerTick = 1000000000D / currFPS;
		setFrames(0);
	}
	
	public static boolean tick() {
		currentTime = System.nanoTime();
		deltaTime += (currentTime - lastTime) / numberOfSecundsPerTick;
		lastTime = currentTime;
		boolean shouldRender = false;
		
		while(deltaTime >= 1){
			ticks++;
			deltaTime -= 1;
			shouldRender = true;
		}
		
		return shouldRender;
	}


	public static void setLastTime() {
		lastTime = System.nanoTime();
	}
	public static long getLastTime() {
		return lastTime;
	}
	
	public static void setCurrentTime() {
		currentTime = System.nanoTime();
	}
	public static long getCurrentTime() {
		return currentTime;
	}

	public static int getFrames() {
		return frames;
	}

	public static void setFrames(int frames) {
		FramesPerSec.frames = frames;
	}
	public static double getDeltaTime() {
		return deltaTime;
	}

	public static void setDeltaTime(int deltaTime) {
		FramesPerSec.deltaTime = deltaTime;
	}
	
	public static void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("" + frames/ticks*60, 10, 10);
	}

}
