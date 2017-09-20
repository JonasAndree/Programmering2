package lesson.draw.objects.fillRect;

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
	private int x = 50;
	private int y = 50;
	private int width = 100;
	private int height = 40;

	public GamePanel() {
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		g.setColor(new Color(190, 81, 215));
		g.fillRect(x, y, width, height);
	}
}
