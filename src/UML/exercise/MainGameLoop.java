package UML.exercise;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * @author Jonas
 *
 */
public class MainGameLoop extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running;
	
	private int fps;
	private int tps;
	
	public static int width;
	public static int height;
	
	public static double currFPS  = 120D;
	
	public Graphics2D graphics2D;
	private BufferedImage img;
	/**
	 * 
	 */
	public MainGameLoop() {
		setFocusable(false);
		requestFocus();
	}
	/**
	 * Runs once when the class starts.
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		
		// Creates a new thread and starts it. 
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	/**
	 * Sets so that the window is set to full screen.
	 */
	@Override
	public Dimension getPreferredSize(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		// Gets the with and height of the screen.
		width = tk.getScreenSize().width;
		height = tk.getScreenSize().height;
		return new Dimension(width, height);
	}
	/**
	 * 
	 */
	@Override
	public void run() {
		System.out.println("Run");
		init();
		
		// returns the most exact time in nanoseconds
		long lastTime = System.nanoTime();
		double numberOfSecundsPerTick = 1000000000D / currFPS;
		int frames = 0; 
		int ticks = 0;
		// returns the current time in milliseconds
		long lastTimer = System.currentTimeMillis();
		// Will speed up the game if the game runs slow
		double deltaTime = 0; 
		
		while (running) {
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / numberOfSecundsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			
			while(deltaTime >= 1){
				ticks++;
				tick(deltaTime);
				deltaTime -= 1;
				shouldRender = true;
			}
			if(shouldRender) {
				frames++;
				render();
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTime += 1000;
				tps = frames;
				fps = ticks;
				frames = 0;
				ticks = 0;
			}
		}
	}
	/**
	 * 
	 */
	public void clear() {
		Graphics g2 = getGraphics();
		if(img != null) {
			g2.drawImage(img, 0, 0, null);
		}
		g2.dispose();
	}
	/**
	 * Initializes all the game objects.
	 */
	public void init(){
		System.out.println("Initializes main game loop");
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2D = (Graphics2D) img.getGraphics();
		running = true;
	}
	/**
	 * Used to update the game.
	 * And speed up if some part of the physics is going slow.
	 * @param deltaTime
	 */
	public void tick(double deltaTime) {
		/* ToDo */
	}
	/**
	 * Will render everything we draw.
	 */
	public void render() {
		graphics2D.clearRect(0, 0, width, height);
	}
}
