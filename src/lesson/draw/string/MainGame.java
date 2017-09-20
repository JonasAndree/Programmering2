package lesson.draw.string;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * 
 * @author Jonas Andrée
 *
 */
public class MainGame {
	public static void main(String[] args) {
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		JFrame f = new JFrame("drawString");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new GamePanel());
		f.pack();
		f.setVisible(true);
	}
}
