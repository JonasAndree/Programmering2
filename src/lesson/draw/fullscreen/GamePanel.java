package lesson.draw.fullscreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 * @author Jonas Andrée
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
	private int x = 50;
	private int y = 50;
	private int width = 100;
	private int height = 40;
	
	public GamePanel(){
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	public Dimension getPreferredSize(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		return new Dimension(tk.getScreenSize().width,tk.getScreenSize().height);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.setColor(new Color(190,81,215));
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.RED);
		g.drawString("Our 2 painting program!", 25, 120);
	}
}
