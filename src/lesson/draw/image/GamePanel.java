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
public class GamePanel extends JPanel implements KeyListener {
	private static int width;
	private static int height;
	
	private int enemyX = 200, enemyY = 400;
	
	private Toolkit tk = Toolkit.getDefaultToolkit();

	private BufferedImage backgroundImage = null;
	private BufferedImage enemy1Image = null;
	
	private Player player1;

	public GamePanel(Player player1) {
		
		this.player1 = player1;
		
		backgroundImage = Utilitis.loadImages("src/lesson/draw/image/destiny-2-logos.png");
		enemy1Image = Utilitis.loadImages("src/lesson/live/graphics/img/hole.png");
		
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
	
	public static int getScreenWidth() {
		return width;
	}
	public static int getScreenHeight() {
		return height;
	}
	
	public Dimension getPreferredSize() {
		width = tk.getScreenSize().width;
		height = tk.getScreenSize().height;
		return new Dimension(width, height);
	}
	
	private void colision(int playerX, int playerY) {
		if ((playerX > enemyX && playerX < enemyX + 32 || playerX + 32 > enemyX && playerX < enemyX + 32) &&
			(playerY > enemyY && playerY < enemyY + 32 || playerY + 32 > enemyY && playerY < enemyY + 32)) {
			//hp--;
		}
	}

	private void update () {
		player1.update();
	}
	
	private void init() {
		player1.init();
		enemyX = 200; 
		enemyY = 400;	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.drawImage(backgroundImage, 0, 0, width, height, 0, 0, backgroundImage.getWidth(),
				backgroundImage.getHeight(), null);		
		
		g.drawImage(enemy1Image, enemyX, enemyY, 32, 32, null);
		
		player1.draw(g);

		g.setColor(Color.DARK_GRAY);
		
		
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
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}
