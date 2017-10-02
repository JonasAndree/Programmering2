package lesson.eventlistener.mainloop.part3.fps.player.movment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements KeyListener {
	// Data for our game character.
	private int x = 450;
	private int y = 600;
	private int width = 32;
	private int height = 32;

	private int startY = 600;
	private boolean jump = false;
	private boolean inAir = false;
	private int jumpSpeedMax = -40;
	private int gravity = 3;
	private int speed = 5;
	private int currentSpeedUp = 0;
	
	private boolean moveRight = false;
	private boolean moveLeft = false;
	

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
			System.out.println(inAir);
			inAir = true;
			currentSpeedUp = jumpSpeedMax;
			y += currentSpeedUp;
		} else if(inAir) {
			System.out.println(currentSpeedUp);
			System.out.println(inAir);
			if (y <= startY) {
				currentSpeedUp += gravity;
				y += currentSpeedUp;
			} else {
				inAir = false;
				y = startY;
				currentSpeedUp = 0;
				jump = false;
			}
		}
	}
	
	public void tick(double deltaTime) {
		if(moveRight)
			moveRight();
		if(moveLeft)
			moveLeft();
		if(jump)
			jump();
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
			jump = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
			
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
