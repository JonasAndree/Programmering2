package lesson.draw.image;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * 
 * @author Jonas Andrée
 *
 */
public class MainGame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Create GUI and EDT?" + SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Painting is fun!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new GamePanel());
		f.pack();
		// f.setUndecorated(true);
		f.setResizable(false);
		f.setAlwaysOnTop(true);
		f.setVisible(true);
	}
}
