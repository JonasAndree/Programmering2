package lesson.draw.string;

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
	public GamePanel() {
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		g.setColor(Color.ORANGE);
		g.drawString("Our first painting program!", 25, 120);
	}
}
