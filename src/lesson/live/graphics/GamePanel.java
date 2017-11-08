package lesson.live.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;




public class GamePanel extends JPanel {
	private int width = 1000;
	private int height = 600;

	private int rectX = 100;
	private int rectY = 150;
	private int rectWidth = 32;
	private int rectHeight = 32;
	
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
		g.setColor(new Color(0, 0, 255));
		rectY = rectY + 1;
		g.fillRect(400, 230, rectWidth, rectHeight);
		
	}
}
