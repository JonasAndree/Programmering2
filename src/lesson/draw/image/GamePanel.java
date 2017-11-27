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
public class GamePanel extends JPanel {
	private int width;
	private int height;

	BufferedImage backgroundImage = null;
	Toolkit tk = Toolkit.getDefaultToolkit();

	public GamePanel() {
		loadImages("src/lesson/draw/image/destiny-2-logos.png");	
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
	public Dimension getPreferredSize() {
		width = tk.getScreenSize().width;
		height = tk.getScreenSize().height;
		return new Dimension(width, height);
	}
	private void loadImages(String url) {
		try {
			backgroundImage = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		g.drawImage(backgroundImage, 0, 0, width, height, 0, 0, backgroundImage.getWidth(),
				backgroundImage.getHeight(), null);
	}
}
