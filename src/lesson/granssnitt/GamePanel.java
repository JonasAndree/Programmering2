package lesson.granssnitt;

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
	private Rectangle rect;

	public GamePanel() {
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
		rect = new Rectangle(20, 20, 200, 200);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		g.setColor(new Color(190, 81, 215));
		rect.draw(g);

	}
}
