package lesson.draw.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Jonas Andrée
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener{
	private int width;
	private int height;
	private boolean up = false, down = false, right = false, left = false;
	private int playerX = 200, playerY = 200;
	
	private int speedX = 0;
	private int speedY = 0;
	
	private BufferedImage backgroundImage = null;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private BufferedImage playerImage = null;

	public GamePanel() {
		loadImages();	
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Thread thread =  new Thread( new Runnable() {
			public void run() {
				while (true) {
					update();
					GamePanel.this.repaint();
					try {
						Thread.sleep(1000/60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		thread.start();
	}
	public Dimension getPreferredSize() {
		width = tk.getScreenSize().width;
		height = tk.getScreenSize().height;
		return new Dimension(width, height);
	}
	private void loadImages() {
		try {
			backgroundImage = ImageIO.read(new File("src/lesson/draw/image/destiny-2-logos.png"));
			playerImage = ImageIO.read(new File("src/lesson/draw/image/PlayerforJonas-1.0.png"));
		} catch (IOException e) {
			e.printStackTrace();
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
		
	}

	private void update () {
		movePlayer();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.drawImage(backgroundImage, 0, 0, width, height, 0, 0, backgroundImage.getWidth(),
				backgroundImage.getHeight(), null);
		
		
		g.drawImage(playerImage, playerX, playerY, 32, 32, null);
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			/*
			 * Write to the terminal if we press the esc button and then close the program
			 * using id 0 saying that the closing of the program went well and natural.
			 * Sometimes when u use get an error you want to close the program in this case
			 * use the id 1. There are many more id's but I'm not going to go through it.
			 */
			System.out.println("Exit program!");
			System.exit(0);
		}
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
