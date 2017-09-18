package lesson.painting2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Jonas Andrée
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel
{
	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 100;
	private int squareH = 40;
	
	public MyPanel(){
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	public Dimension getPreferredSize(){
		return new Dimension(400,600);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
	    
		g.setColor(new Color(190,81,215));
		g.fillRect(squareX, squareY, squareW, squareH);
		
		g.setColor(Color.RED);
		g.drawString("Our first painting program!", 25, 120);
	}
}
