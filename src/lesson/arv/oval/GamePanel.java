package lesson.arv.oval;

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
	OvaL oval, oval1;
	
	public GamePanel() {
		oval = new OvaL(50, 50, 100, 40);
		oval1 = new OvaL(120, 120, 50, 30);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		oval.setColor(255, 50, 100);
		oval.draw(g);
		oval1.draw(g);
		
	}
}
