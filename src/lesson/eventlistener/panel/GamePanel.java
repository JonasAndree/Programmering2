package lesson.eventlistener.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * The game panel our first game structure If you make a class with some
 * methods, variables and constants, you might want to be able to build on the
 * class. Like when you have a class called cars that describes all kinds of
 * cars and you want to make a specific car like the v70 then you want to reuse
 * the class car. Then you should use extends.
 * 
 * @author Jonas Andrée
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener {
	// Data for our game character.
	private int x = 450;
	private int y = 600;
	private int width = 40;
	private int height = 40;

	private boolean inAir = false;
	private int jumpHeight = 200;
	private int gravity = 10;
	private int speed = 10;

	/*
	 * Generally you do not want variables to be directly accessible from other
	 * classes. But if you want an other class to be able to change them you create
	 * getters and setters. like the two bellow.
	 */
	public void moveRight() {
		x += speed;
		repaint();
	}

	/**
	 * 
	 */
	public void moveLeft() {
		x -= speed;
		repaint();
	}

	/**
	 * The jump function starts a thread.
	 */
	public void jump() {
		if (!inAir) {
			inAir = true;
			int startY = y;
			y -= jumpHeight;
			System.out.println(startY + ":" + gravity);

			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						System.out.println(y);
						if (y < startY) {
							y += gravity;
							try {
								Thread.sleep(20);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							y = startY;
							inAir = false;
							break;
						}
						repaint();
					}
				}
			});
			thread.start();
		}
	}

	/**
	 * Constructor. Used when we want something to happen when the class is created
	 * the first time.
	 */
	public GamePanel() {
	}

	/**
	 * Sets so that the window is set to full screen.
	 */
	@Override
	public Dimension getPreferredSize() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		// Gets the with and height of the screen.
		return new Dimension(tk.getScreenSize().width, tk.getScreenSize().height);
	}

	/**
	 * Paints to the JPanel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
