package lesson.arv.rectangle;

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
public class GamePanel extends JPanel {
	Rectangle rect, rect1;
	
	public GamePanel() {
		rect = new Rectangle(50, 50, 100, 40);
		rect1 = new Rectangle(120, 120, 50, 30);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		rect.setColor(255, 50, 100);
		rect.draw(g);
		rect1.draw(g);
	}
}
