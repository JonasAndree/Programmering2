package lesson.maze.painting.images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Jonas Andrée
 * 
 */
public class MainGame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		});
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	private static void createAndShowGUI() throws InterruptedException {
		JFrame f = new JFrame("Painting is fun!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		f.add(new MazePanel(), BorderLayout.PAGE_END);
		f.setResizable(false);
		f.setAlwaysOnTop(true);

		// Sets so there is no borders
		f.setUndecorated(true);

		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) { // handler
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.out.println("Exit program!");
					System.exit(0);
				} else {
					System.out.println("not escaped");
				}
			}
		});

		// Display the window.
		f.pack();
		f.setVisible(true);
	}
}
