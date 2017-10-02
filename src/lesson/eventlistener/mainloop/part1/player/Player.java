package lesson.eventlistener.mainloop.part1.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	// Data for our game character.
	private int x = 450;
	private int y = 600;
	private int width = 32;
	private int height = 32;

	private boolean inAir = false;
	private int jumpHeight = 200;
	private int gravity = 10;
	private int speed = 10;

	public Player() {

	}

	/*
	 * Generally you do not want variables to be directly accessible from other
	 * classes. But if you want an other class to be able to change them you create
	 * getters and setters. like the two bellow.
	 */
	public void moveRight() {
		x += speed;
	}

	/**
	 * 
	 */
	public void moveLeft() {
		x -= speed;
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
					}
				}
			});
			thread.start();
		}
	}

	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Player.this.jump();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Player.this.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Player.this.moveLeft();
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
