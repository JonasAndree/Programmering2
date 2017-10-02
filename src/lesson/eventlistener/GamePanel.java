package lesson.eventlistener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * The game panel our first game structure If you make a class with some
 * methods, variables and constants, you might want to be able to build on the
 * class. Like when you have a class called cars that describes all kinds of
 * cars and you want to make a specific car like the v70 then you want to reuse
 * the class car. Then you should use extends.
 * 
 * @author Jonas Andrée
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	// Data for our game character.
	private int x = 450;
	private int y = 600;
	private int width = 40;
	private int height = 40;


	/**
	 * Constructor. Used when we want something to happen when the class is created
	 * the first time.
	 */
	public GamePanel() {
	}

	/**
	 * Sets so that the window is set to full screen.
	 */
	@Override
	public Dimension getPreferredSize() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		// Gets the with and height of the screen.
		return new Dimension(tk.getScreenSize().width, tk.getScreenSize().height);
	}

	/**
	 * Paints to the JPanel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

}
