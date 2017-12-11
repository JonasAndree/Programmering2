package lesson.draw.image;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Player implements KeyListener {
	
	private boolean up = false, down = false, right = false, left = false;
	private int playerX, playerY;
	
	private BufferedImage playerImage = null;
	private int speedX = 0;
	private int speedY = 0;
	private int startHP = 100;
	
	private HB hP = new HB(startHP);
	
	
	public Player() {
		playerImage = Utilitis.loadImages("src/lesson/draw/image/PlayerforJonas-1.0.png");
		init();
	}
	public void init() {
		playerX = 200;
		playerY = 200;
		hP.init(startHP);
		speedX = 0;
		speedY = 0;
		
	}
	
	private void detectLife() {
		if (hP.getHP() <= 0 ) {
			init();
		}
	}
	private void movePlayer() {
		if (up == true)
			speedY = -5;
		if (down == true)
			speedY = 5;
		if (!down && !up)
			speedY = 0;
		if (right == true)
			speedX = 5;
		if (left == true)
			speedX = -5;		
		if (!left && !right)
			speedX = 0;
		
		playerX += speedX;
		playerY += speedY;
		
		//colision(playerX, playerY);
	}
	
	public void update() {
		movePlayer();
		detectLife();
	}
	public void draw(Graphics g) {
		g.drawImage(playerImage, playerX, playerY, 32, 32, null);
		hP.draw(g);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			down = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			right = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			up = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			down = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			right = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			left = false;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
