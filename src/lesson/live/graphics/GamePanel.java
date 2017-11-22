package lesson.live.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;




public class GamePanel extends JPanel implements KeyListener {
	private int width = 1000;
	private int height = 600;

	private int rectX = 100;
	private int rectY = 150;
	private int rectWidth = 32;
	private int rectHeight = 32;
	
	private int playerX = 200;
	
	public GamePanel() {
		Thread thread =  new Thread( new Runnable() {
			public void run() {
				while (true) {
					System.out.println("Thread running!");
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
		return new Dimension(width, height);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.setColor(new Color(255, 0, 255));
		g.drawLine(4, 5, 100, 150);
		
		g.fillRect(rectX++, rectY, rectWidth, rectHeight);
		rectY = rectY + 1;
		
		
		g.setColor(new Color(0, 0, 255));
		g.fillRect(playerX, 230, rectWidth, rectHeight);
		
	}
	
	private void movePlayerX(boolean direction) {
		if (direction == true)
			playerX += 5;
		else 
			playerX -= 5;
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
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			movePlayerX(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			movePlayerX(false);
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
