package lesson.eventlistener.mainloop.part4.loop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * The game panel our first game structure If you make a class with some
 * methods, variables and constants, you might want to be able to build on the
 * class.
 * 
 * @author Jonas Andrée
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	private Thread thread;
	private boolean running;

	Graphics graphics2D;
	private BufferedImage img;

	private static int width;
	private static int height;

	Player player;
	
	/**
	 * Constructor. Used when we want something to happen when the class is created
	 * the first time.
	 */
	public GamePanel(GameWindow window) {
		System.out.println("Constructiong main panel.");
		// Gets the with and height of the screen.
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.width = tk.getScreenSize().width;
		this.height = tk.getScreenSize().height;

		player = new Player();
		window.addKeyListener(player);
	}

	/**
	 * Initializes all the game objects.
	 */
	public void init() {
		System.out.println("Initializes main game loop.");
		running = true;
		FramesPerSec.init();
	}

	/**
	 * Sets so that the window is set to full screen.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	/**
	 * Paints to the JPanel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		player.render(g);
		FramesPerSec.render(g);
	}

	/**
	 * Runs once when the class starts.
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		/*
		 * Creates a new thread and starts it and makes it be this class.
		 */
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	/**
	 * Used to update the game. And speed up if some part of the physics is going
	 * slow.
	 * 
	 * @param deltaTime
	 */
	public void tick(double deltaTime) {
		player.tick(deltaTime);
	}

	@Override
	public void run() {
		System.out.println("The main thread is running");
		init();
		
		// Creates out infinite main loop
		while (running) {
			if(FramesPerSec.tick()) {
				tick(FramesPerSec.getDeltaTime());
				FramesPerSec.setFrames(FramesPerSec.getFrames() + 1);
				repaint();
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static int getScreenWidth() {
		return width;
	}
	public static int getScreenHeight() {
		return height;
	}
}
