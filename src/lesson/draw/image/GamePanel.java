package lesson.draw.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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
public class GamePanel extends JPanel
{
	private int x = 50;
	private int y = 50;
	private int width = 100;
	private int height = 40;
	Toolkit tk = Toolkit.getDefaultToolkit();
	
	public GamePanel(){
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	public Dimension getPreferredSize(){
		
		return new Dimension(tk.getScreenSize().width,tk.getScreenSize().height);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/lesson/draw/image/destiny-2-logos.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		g.drawImage(img, 
	            0, 0, tk.getScreenSize().width,  tk.getScreenSize().height,
	            0, 0, img.getWidth(), img.getHeight(),
	            null);  
	}
}
